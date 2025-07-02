package design.patterns;

class Logger {

    private static Logger loggerObj;

    private Logger() {}

    public static Logger getLogger() {
        if (loggerObj == null) {
            loggerObj = new Logger();
        }
        return loggerObj;
    }

    public void log(String msg) {
        System.out.println(msg);
    }

}

public class Singleton {

    public static void main(String[] args) {
        Logger obj1 = Logger.getLogger();
        Logger obj2 = Logger.getLogger();
        System.out.println(obj1 == obj2);
    }

}