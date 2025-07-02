package design.patterns;

abstract class LogMsg {

    public void log(String msg) {
        System.out.println(msg);
    }

}



/*

❌ Thread-safe: Not, if 2 threads call getInstance() at the same time, both can pass the null check and create 2 objects, breaking Singleton

*/
class Logger extends LogMsg {

    private static Logger loggerObj;

    private Logger() {}

    public static Logger getLogger() {
        if (loggerObj == null) {
            loggerObj = new Logger();
        }
        return loggerObj;
    }

}



/*  Synchronized Method

✅ Thread-safe: Yes
✅ Slow: Yes due to lazy loading (created only when needed)
❌ Performance: "synchronized" slows down every call to getInstance() — even after the instance is created

*/



/*  Eager Initialization

✅ Thread-safe: JVM ensures thread-safe class loading, JVM loads static variables only once per class, and that process is thread-safe by default
✅ Fast: Due to Eager Initialization, no synchronization needed
❌ Performance: instance is created when class is loaded — even if never used - no support for lazy loading

*/
class ThreadSafeLogger extends LogMsg {

    private static final ThreadSafeLogger threadSafeLoggerObj = new ThreadSafeLogger();

    private ThreadSafeLogger() {}

    public static ThreadSafeLogger getLogger() {
        return threadSafeLoggerObj;
    }

}

public class Singleton {

    public static void main(String[] args) {

        // not thread safe
        Logger obj1 = Logger.getLogger();
        Logger obj2 = Logger.getLogger();
        System.out.println(obj1 == obj2);

        // thread safe
        ThreadSafeLogger obj3 = ThreadSafeLogger.getLogger();
        ThreadSafeLogger obj4 = ThreadSafeLogger.getLogger();
        System.out.println(obj3 == obj4);

        obj4.log("Implemented singleton pattern successfully");
    }

}