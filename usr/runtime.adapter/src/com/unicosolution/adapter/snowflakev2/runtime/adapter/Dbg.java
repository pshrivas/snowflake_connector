/*
 * Copyright (c) 2012-2015 Snowflake Computing Inc. All right reserved.
 */
package com.unicosolution.adapter.snowflakev2.runtime.adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import java.util.logging.Level;

/**
 * Utility class for debugging and logging Addition to logger and system out.
 */
public class Dbg {

	public static final String DEBUG_PROPERTY = "snowflake.connector.log.level";
    public static final String FILE_PROPERTY = "snowflake.connector.log.file";    
    
    static final String _tempdir = System.getProperty("java.io.tmpdir");
    static final String DEFAULT_FILE = _tempdir
            + (!(_tempdir.endsWith("/") || _tempdir.endsWith("\\")) ? File.separatorChar : "")
            + "infadbg.txt";
    public static final String LOG_FILE_NAME
            = System.getProperty(FILE_PROPERTY) != null
                    ? System.getProperty(FILE_PROPERTY)
                    : DEFAULT_FILE;

    private static FileOutputStream logFile = null;

    static TreeMap<String, FileOutputStream> output = new TreeMap<String, FileOutputStream>();

    // Format Longs above that value as Date
    static long magicNumber = System.currentTimeMillis() - 100000L;

    static Level logLevel = Level.WARNING;

    static {
        String configuredLevel = System.getProperty(DEBUG_PROPERTY);
        if (configuredLevel == null) {
            logLevel = Level.WARNING;
        } else {
            logLevel = Level.parse(configuredLevel);
        }
    }

    public static void warning(Object... what) {
        if (logLevel.intValue() <= Level.WARNING.intValue()) {
            write(what);
        }
    }

    public static void info(Object... what) {
        if (logLevel.intValue() <= Level.INFO.intValue()) {
            write(what);
        }
    }

    public static void fine(Object... what) {
        if (logLevel.intValue() <= Level.FINE.intValue()) {
            write(what);
        }
    }

    public static void finest(Object... what) {
        if (logLevel.intValue() <= Level.FINEST.intValue()) {
            write(what);
        }
    }

    public static boolean enabled() {
        if (logLevel.intValue() < Level.OFF.intValue()) {
            if (logFile != null) {
                return true;
            } else if ((logFile = open(LOG_FILE_NAME)) != null) {
                String tmp = "Opened log file: Level=" + logLevel.toString() + "\n";
                try {
                    logFile.write(tmp.getBytes());
                } catch (IOException ex) {
                    //doh
                }
                return true;
            }
        }

        return false;
    }

    public static Level getLogLevel()
    {
        return logLevel;
    }

    private static void write(Object... what) {
        if (!enabled()) {
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");

        try {
            logFile.write(sdf.format(new Date()).getBytes());
            logFile.write(": ".getBytes());
            if (logLevel.intValue() < Level.FINE.intValue()) {
                logFile.write(Thread.currentThread().getStackTrace()[3].toString().getBytes());
                logFile.write("-> ".getBytes());
                logFile.write(Thread.currentThread().getStackTrace()[2].toString().getBytes());
                logFile.write(": ".getBytes());
            }

            for (Object w : what) {
                if (w instanceof Long && ((Long) w) > magicNumber) {
                    logFile.write(String.valueOf(new Date((Long) w)).getBytes());
                    logFile.write('[');
                    logFile.write(String.valueOf(w).getBytes());
                    logFile.write(']');
                } 
                else if(w instanceof Date)
                {
                    logFile.write(String.valueOf(w).getBytes());
                    logFile.write('[');
                    logFile.write(String.valueOf(((Date)w).getTime()).getBytes());
                    logFile.write(']');                    
                }
                else if(w instanceof java.sql.Timestamp)
                {
                    logFile.write(String.valueOf(w).getBytes());
                    logFile.write('[');
                    logFile.write(String.valueOf(((java.sql.Timestamp)w).getTime()).getBytes());
                    logFile.write(']');                    
                }
                else
                {
                    logFile.write(String.valueOf(w).getBytes());
                }
                logFile.write(", ".getBytes());
            }
            logFile.write('\n');
            logFile.flush();
        } catch (IOException ex) {
            String tmp = "Error: " + ex.toString();
            try {
                logFile.write(tmp.getBytes());
                logFile.flush();
            } catch (IOException ex2) {
                // doh
            }
        }
    }

    private synchronized static FileOutputStream open(String fname) {

        FileOutputStream out = output.get(fname);
        if (out == null) {
            try {
                out = new FileOutputStream(fname, true);
            } catch (FileNotFoundException ex) {
                //doh
            }
            output.put(fname, out);
            return out;
        } else {
            return out;
        }
    }
}
