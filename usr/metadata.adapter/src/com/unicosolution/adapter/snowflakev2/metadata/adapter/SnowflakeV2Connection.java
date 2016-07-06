package com.unicosolution.adapter.snowflakev2.metadata.adapter;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import com.informatica.sdk.adapter.metadata.common.Status;
import com.informatica.sdk.adapter.metadata.common.StatusEnum;
import com.informatica.sdk.adapter.metadata.provider.AbstractConnection;

public class SnowflakeV2Connection extends AbstractConnection {

	private Connection conn;

	public String db;
	
	private String schema;

	/**
	 * Establishes a connection with the external data source.
	 * 
	 * @param connAttrs
	 *            The list of connection attributes.
	 * @return The Status of the connection.
	 */
	
	
	    @Override
	    @SuppressWarnings("unused")
	    public Status openConnection(Map<String, Object> connAttrs){

	    	String account = (String) connAttrs.get("account");
	    	String user = (String) connAttrs.get("user");
			String password = (String) connAttrs.get("password");
			
			String warehouse = (String) connAttrs.get("warehouse");
			db = (String) connAttrs.get("db");
			schema = (String) connAttrs.get("schema");

			String authenticator = (String) connAttrs.get("authenticator");
			String role = (String) connAttrs.get("role");
			String tracing = (String) connAttrs.get("tracing");
			String passcode = (String) connAttrs.get("passcode");
			boolean passcodeInPassword = (boolean) connAttrs.get("passcodeInPassword");

			String queryString = "";
			
			/* warehouse, db & schema are mandatory parameters. Still checking to be sure */
			if (null != warehouse  && !"".equals(warehouse)){
				queryString = queryString + "warehouse=" + warehouse;
			}
			if (null != db  && !"".equals(db)){
				queryString = queryString + "&db=" + db;
			}
			if (null != schema  && !"".equals(schema)){
				queryString = queryString + "&schema=" + schema;
			}		
			
			if (null != authenticator  && !"".equals(authenticator)){
				queryString = queryString + "&authenticator=" + authenticator;
			}		
			if (null != role  && !"".equals(role)){
				queryString = queryString + "&role=" + role;
			}		
			if (null != tracing  && !"".equals(tracing)){
				queryString = queryString + "&tracing=" + tracing;
			}		
			if (null != passcode  && !"".equals(passcode)){
				queryString = queryString + "&passcode=" + passcode;
			}		
			queryString = queryString + "&passcodeInPassword=" + String.valueOf(passcodeInPassword);

			String connectionURL = "jdbc:snowflake://" + account + ".snowflakecomputing.com" + "/?" 
															+ queryString;
				
			String JDBC_DRIVER = "com.snowflake.client.jdbc.SnowflakeDriver";

			try {
				DriverClassLoader driverClassLoader = new DriverClassLoader(com.snowflake.client.jdbc.SnowflakeConnection.class.getClassLoader());
				Driver driver = (Driver) Class.forName(JDBC_DRIVER, true, driverClassLoader).newInstance();
				DriverManager.registerDriver(new DriverWrapper(driver));

				conn = DriverManager.getConnection(connectionURL, user, password);
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
	    public Status closeConnection(){
			try {
				conn.close();
			} catch (Exception e) {
				return new Status(StatusEnum.FAILURE, e.getMessage());
			}
			return new Status(StatusEnum.SUCCESS, null);
	    }



	    /**
	     * A provisional method to access the native connection object that will 
	     * be set as a part of the openConnection() method. 
	     * 
	     * @return The native connection object.
	     */ 

	    public Connection getSnowflakeConnection(){
	    	return conn;
	    }
	    
	    /**
	     * 
	     * @return the db name (catalog)
	     */
	    public String getCatalog() {
	    	return db;
	    }

	    
	    /**
	     * Return the name of the Schema within the selected catalog (db)
	     */
	    public String getSchema() {
	    	return schema;
	    }
		/**
		 * Inner class.<br>
		 * Custom driver class loader for loading the third party jar.
		 * 
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



}