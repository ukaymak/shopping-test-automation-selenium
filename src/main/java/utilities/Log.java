package utilities;


import org.apache.log4j.Logger;

public class Log {

    //Initialize Log4j instance
    private static Logger consoleLog = Logger.getLogger(Log.class.getName());

    //Info Level Logs
    public static void info(String message) {

        consoleLog.info(message);
    }
    //Warn Level Logs
    public static void warn(String message) {

        consoleLog.warn(message);
    }
    //Error Level Logs
    public static void error(String message) {

        consoleLog.error(message);
    }
    //Fatal Level Logs
    public static void fatal(String message) {

        consoleLog.fatal(message);
    }
    //Debug Level Logs
    public static void debug(String message) {

        consoleLog.debug(message);
    }
}
