package design.patterns;

abstract class LogMsg {

    public void log(String msg) {
        System.out.println(msg);
    }

}



/*

❌ Thread-safe: Not, if 2 threads call getLogger() at the same time, both can pass the null check and create 2 objects, breaking Singleton

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



/*  Lazy Initialization (instance created only when needed)

✅ Thread-safe: Yes
❌ Performance: "synchronized" ensures only one thread can access the method at a time, slows down every call to getLogger() — even after the instance is created

*/
class ThreadSafeSlowLogger extends LogMsg {

    private static ThreadSafeSlowLogger loggerObj;

    private ThreadSafeSlowLogger() {}

    public static synchronized ThreadSafeSlowLogger getLogger() {
        if (loggerObj == null) {
            loggerObj = new ThreadSafeSlowLogger();
        }
        return loggerObj;
    }

}


/*  Eager Initialization

✅ Thread-safe: JVM ensures thread-safe class loading, JVM loads static variables only once per class, and that process is thread-safe by default
✅ Fast: Due to Eager Initialization, no synchronization needed
❌ Instance is created when class is loaded — even if never used - no support for lazy loading

*/
class ThreadSafeFastLogger extends LogMsg {

    private static final ThreadSafeFastLogger LOGGER_OBJ = new ThreadSafeFastLogger();

    private ThreadSafeFastLogger() {}

    public static ThreadSafeFastLogger getLogger() {
        return LOGGER_OBJ;
    }

}

public class Singleton {

    public static void main(String[] args) {

        // not thread safe
        var obj1 = Logger.getLogger();
        var obj2 = Logger.getLogger();
        System.out.println(obj1 == obj2);

        // thread safe + slow
        var obj3 = ThreadSafeSlowLogger.getLogger();
        var obj4 = ThreadSafeSlowLogger.getLogger();
        System.out.println(obj3 == obj4);

        // thread safe + fast
        var obj5 = ThreadSafeFastLogger.getLogger();
        var obj6 = ThreadSafeFastLogger.getLogger();
        System.out.println(obj5 == obj6);

        obj4.log("Implemented singleton pattern successfully");
    }

}