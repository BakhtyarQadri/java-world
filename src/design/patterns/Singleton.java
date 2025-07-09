package design.patterns;

abstract class LogMsg {

    public void log(String msg) {
        System.out.println(msg);
    }

}



/*

❌ Thread-safe: Not, if 2 threads call getLogger() at the same time, both can pass the null check and create 2 objects, breaking Singleton
✅ Lazy Initialization

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
✅ High Performance: Due to Eager Initialization, no synchronization needed
❌ Lazy Loading: instance is created when class is loaded — even if never used
❌ Reflection Safe: we can set the private constructor to become accessible at runtime using reflection
❌ Serialization/Deserialization Safe

*/
class ThreadSafeFastLogger extends LogMsg {

    private static final ThreadSafeFastLogger LOGGER_OBJ = new ThreadSafeFastLogger();

    private ThreadSafeFastLogger() {}

    public static ThreadSafeFastLogger getLogger() {
        return LOGGER_OBJ;
    }

}

/*  Enum

✅ Thread-safe: Enums are inherently thread-safe in Java. The JVM guarantees that enum constants are initialized only once even in a multi-threaded environment.
✅ High Performance
❌ Lazy Initialization: JVM automatically creates a private constructor, initializes the INSTANCE field during class loading.
✅ Reflection Safe
✅ Serialization/Deserialization Safe

*/
enum EnumLogger {

    INSTANCE;

    public void log(String msg) {
        System.out.println(msg);
    }
}

public class Singleton {

    public static void main(String[] args) {

        // not thread safe
        var obj1 = Logger.getLogger();
        var obj2 = Logger.getLogger();
        System.out.println(obj1 == obj2);

        var obj3 = ThreadSafeSlowLogger.getLogger();
        var obj4 = ThreadSafeSlowLogger.getLogger();
        System.out.println(obj3 == obj4);

        var obj5 = ThreadSafeFastLogger.getLogger();
        var obj6 = ThreadSafeFastLogger.getLogger();
        System.out.println(obj5 == obj6);

        var obj7 = EnumLogger.INSTANCE;
        var obj8 = EnumLogger.INSTANCE;
        System.out.println(obj7 == obj8);

        obj8.log("Implemented singleton pattern successfully");
    }

}