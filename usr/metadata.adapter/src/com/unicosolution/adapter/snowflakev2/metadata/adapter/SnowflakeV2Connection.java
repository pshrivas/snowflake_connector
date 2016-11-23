package com.unicosolution.adapter.snowflakev2.metadata.adapter;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.informatica.sdk.adapter.metadata.common.Status;
import com.informatica.sdk.adapter.metadata.common.StatusEnum;
import com.informatica.sdk.adapter.metadata.provider.AbstractConnection;
import net.snowflake.client.loader.Loader;
import net.snowflake.client.loader.LoaderFactory;
import net.snowflake.client.loader.LoaderProperty;

public class SnowflakeV2Connection extends AbstractConnection {
	Logger LOGGER = Logger.getLogger(SnowflakeV2Connection.class.getName());

	public static final String JDBC_URL_PREFIX = "jdbc:snowflake";

	private NativeConnectionHolder nativeConnectionHolder;

	private String user; // required
	private String account; // required
	private String db; // optional (can be null)
	private String schema; // optional (can be null)

	/**
	 * Establishes a connection with the external data source.
	 * 
	 * @param connAttrs
	 *            The list of connection attributes.
	 * @return The Status of the connection.
	 */

	@Override
	public Status openConnection(Map<String, Object> connAttrs) {
		if (LOGGER.isLoggable(Level.FINER)) {
			Map<String, Object> tmpConnAttrs = new HashMap<>(connAttrs);
			if (tmpConnAttrs.containsKey("password")) {
				tmpConnAttrs.remove("password");
			}
			LOGGER.finer(String.format("ConnAttrs: %s", tmpConnAttrs));
		}
		this.account = (String) connAttrs.get("account"); // required
		this.user = (String) connAttrs.get("user"); // required
		String password = (String) connAttrs.get("password"); // required

		this.db = (String) connAttrs.get("db");
		this.schema = (String) connAttrs.get("schema");
		String warehouse = (String) connAttrs.get("warehouse");
		String role = (String) connAttrs.get("role");

		boolean useCustomURL = (boolean) connAttrs.get("useCustomURL");
		boolean clientSessionKeepAlive = (boolean) connAttrs.get("clientSessionKeepAlive");

		String connectionURL = "";

		if (!useCustomURL) {
			String queryString = "";

			// db & schema are mandatory parameters. Still checking to be sure
			if (null != warehouse && !"".equals(warehouse)) {
				queryString = queryString + "warehouse=" + warehouse;
			}
			if (null != db && !"".equals(db)) {
				queryString = queryString + "&db=" + db;
			}
			if (null != schema && !"".equals(schema)) {
				queryString = queryString + "&schema=" + schema;
			}
			if (null != role && !"".equals(role)) {
				queryString = queryString + "&role=" + role;
			}
			if (clientSessionKeepAlive) {
				// don't include this in URL if not enabled
				queryString = queryString + "&CLIENT_SESSION_KEEP_ALIVE=true";
			}
			queryString = queryString + "&SSL=on"; // always on by default

			connectionURL = JDBC_URL_PREFIX + "://" + account + ".snowflakecomputing.com" + "/?" + queryString;
		} else {
			String customURL = (String) connAttrs.get("customURL");
			URI customURI = URI.create(customURL.replace(JDBC_URL_PREFIX, "http"));
			Map<String, List<String>> queryMap = null;
			try {
				queryMap = SnowflakeV2Connection.splitQuery(customURI.toURL());
			} catch (UnsupportedEncodingException | MalformedURLException e) {
				return new Status(StatusEnum.FAILURE,
						String.format("Failed to parse JDBC URL: %s, Error: %s", customURL, e.getMessage()));
			}

			/*
			 * user, account and password must be specified in separate fields
			 * and not part of JDBC URL. The following just caches db and schema
			 * if specified but optional
			 */
			List<String> dbList = queryMap.get("db");
			if (dbList.size() > 0) {
				db = dbList.get(0);
			}
			List<String> schemaList = queryMap.get("schema");
			if (schemaList.size() > 0) {
				schema = schemaList.get(0);
			}
			connectionURL = customURL;
		}

		String JDBC_DRIVER = "net.snowflake.client.jdbc.SnowflakeDriver";

		try {
			Class.forName(JDBC_DRIVER);
			LOGGER.finer(String.format("JDBC URL: %s", connectionURL));
			Connection conn1 = DriverManager.getConnection(connectionURL, user, password);
			Connection conn2 = DriverManager.getConnection(connectionURL, user, password);

			nativeConnectionHolder = new NativeConnectionHolder(conn1, conn2);

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage().contains("Communications link failure")) {
				return new Status(StatusEnum.FAILURE, "Invalid hostname or port number");
			}
			return new Status(StatusEnum.FAILURE, e.getMessage());
		}
		return new Status(StatusEnum.SUCCESS, null);
	}

	/**
	 * Closes the connection of the data source.
	 * 
	 * @return The Status of the connection.
	 */

	@Override
	public Status closeConnection() {
		LOGGER.finer("");
		try {
			Connection conn1 = nativeConnectionHolder.getPutConnection();
			Connection conn2 = nativeConnectionHolder.getProcessConnection();

			if (null != conn1 && !conn1.isClosed()) {
				conn1.close();
			}
			if (null != conn2 && !conn2.isClosed()) {
				conn2.close();
			}
		} catch (Exception e) {
			return new Status(StatusEnum.FAILURE, e.getMessage());
		}
		return new Status(StatusEnum.SUCCESS, null);
	}

	/**
	 * A provisional method to access the native connection object that will be
	 * set as a part of the openConnection() method.
	 * 
	 * @return The native connection object.
	 */

	// Call this method for Metadata Read and Table Data Read operations
	public Connection getSnowflakeConnection() {
		return (Connection) nativeConnectionHolder.getProcessConnection();
	}

	// Call this method for Table Data Write (bulk)
	public NativeConnectionHolder getSnowflakeNativeConnectionHolder() {
		return nativeConnectionHolder;
	}

	/**
	 * Returns the name of Database name.
	 * 
	 * @return the db name (catalog). null if not specified in the connection
	 *         attributes.
	 */
	public String getCatalog() {
		return db;
	}

	/**
	 * Return the name of the Schema within the selected catalog (db)
	 * 
	 * @return the schema name. null if not specified in the connection
	 *         attributes.
	 */
	public String getSchema() {
		return schema;
	}

	/**
	 * Instantiates and returns the Loader
	 * 
	 * @param recordInfo
	 * @return
	 */
	public Loader getStreamLoader(RecordMeta recordInfo) {

		Map<LoaderProperty, Object> prop = new EnumMap<LoaderProperty, Object>(LoaderProperty.class);
		prop.put(LoaderProperty.tableName, recordInfo.getRecordName());
		prop.put(LoaderProperty.schemaName, getSchema());
		prop.put(LoaderProperty.databaseName, getCatalog());
		prop.put(LoaderProperty.remoteStage, "~");
		prop.put(LoaderProperty.keys, recordInfo.getKeys());
		prop.put(LoaderProperty.columns, recordInfo.getColumns());

		Loader loader = LoaderFactory.createLoader(prop, nativeConnectionHolder.getPutConnection(),
				nativeConnectionHolder.getProcessConnection());

		return loader;

	}

	/**
	 * Inner class.<br>
	 * Custom driver class loader for loading the third party jar.
	 * 
	 * TODO: Shige: o we still need this?
	 */
	public static class DriverClassLoader extends URLClassLoader {

		private static final String SYSTEM_CLASSPATH = System.getenv("CLASSPATH");
		private static final String INFA_JAVA_CMD_CLASSPATH = System.getenv("INFA_JAVA_CMD_CLASSPATH");
		private static final String OSNAME = "os.name";

		public DriverClassLoader(ClassLoader parent) throws MalformedURLException {
			super(getClassPathURL(parent), parent);
		}

		private static URL[] getClassPathURL(ClassLoader parentLoader) throws MalformedURLException {
			List<URL> jars;

			jars = getClassPathURL(parentLoader, INFA_JAVA_CMD_CLASSPATH);
			jars.addAll(getClassPathURL(parentLoader, SYSTEM_CLASSPATH));

			URL[] urlArray = new URL[jars.size()];
			return jars.toArray(urlArray);
		}

		private static List<URL> getClassPathURL(ClassLoader parentLoader, String classpathVariable)
				throws MalformedURLException {
			List<URL> jars = new ArrayList<URL>();
			if (classpathVariable == null)
				return jars;

			Properties prop = System.getProperties();
			String osName = ((String) prop.get(OSNAME)).toUpperCase();

			StringTokenizer st1;
			if (osName.indexOf("WIN") >= 0)
				st1 = new StringTokenizer(classpathVariable, ";");
			else
				st1 = new StringTokenizer(classpathVariable, ":");

			String jarName;
			File jarFile;
			while (st1.hasMoreTokens()) {
				jarName = st1.nextToken();
				if (jarName.endsWith("*")) {
					// it should be directory
					int len = jarName.length();
					String directoryName = jarName.substring(0, len - 1);
					File directoryFile = new File(directoryName);
					if (directoryFile.isDirectory()) {
						addDirectory(jars, directoryFile);
					}
				} else if (jarName.toUpperCase(Locale.ENGLISH).endsWith(".JAR")) {
					jarFile = new File(jarName);
					try {
						jars.add(jarFile.toURI().toURL());
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}
			}

			return jars;
		}

		private static void addDirectory(List<URL> jars, File directoryFile) throws MalformedURLException {
			for (File f : directoryFile.listFiles()) {
				if (f.isDirectory()) {
					addDirectory(jars, f);
				} else if (f.getName().toUpperCase(Locale.ENGLISH).endsWith(".JAR")) {
					jars.add(f.toURI().toURL());
				}
			}
		}
	}

	/**
	 * Inner class.<br>
	 * Custom driver wrapper class
	 * 
	 * TODO: Shige: o we still need this?
	 */

	public class DriverWrapper implements Driver {
		private Driver driver;

		public DriverWrapper(Driver d) {
			this.driver = d;
		}

		public boolean acceptsURL(String u) throws SQLException {
			return this.driver.acceptsURL(u);
		}

		public Connection connect(String u, Properties p) throws SQLException {
			return this.driver.connect(u, p);
		}

		public int getMajorVersion() {
			return this.driver.getMajorVersion();
		}

		public int getMinorVersion() {
			return this.driver.getMinorVersion();
		}

		public DriverPropertyInfo[] getPropertyInfo(String u, Properties p) throws SQLException {
			return this.driver.getPropertyInfo(u, p);
		}

		public boolean jdbcCompliant() {
			return this.driver.jdbcCompliant();
		}

		@Override
		public Logger getParentLogger() throws SQLFeatureNotSupportedException {
			return this.driver.getParentLogger();
		}
	}

	/**
	 * Parses JDBC URL to get the parameters in a query string.
	 * 
	 * @param url
	 * @return query key and value pairs
	 * @throws UnsupportedEncodingException
	 */
	private static Map<String, List<String>> splitQuery(URL url) throws UnsupportedEncodingException {
		final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
		final String[] pairs = url.getQuery().split("&");
		for (String pair : pairs) {
			final int idx = pair.indexOf("=");
			final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
			if (!query_pairs.containsKey(key)) {
				query_pairs.put(key, new LinkedList<String>());
			}
			final String value = idx > 0 && pair.length() > idx + 1
					? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
			query_pairs.get(key).add(value);
		}
		return query_pairs;
	}

}