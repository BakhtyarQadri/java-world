public class Generic {

    public static void main(String[] args) {

        welcome("Welcome Player", 456);

        var stringPrinter = new Printer<String>();
        stringPrinter.log("string printer");

        var integerPrinter = new Printer<Integer>();
        integerPrinter.log(456);
        System.out.println(integerPrinter.getMessage(456));

    }

    // Generic Method
    private static <Param1, Param2> void welcome(Param1 msg1, Param2 msg2) {
        System.out.println(msg1 + " " + msg2);
    }

}

// Generic Class
class Printer<T> {

    public void log(T message) {
        System.out.println(message);
    }

    public T getMessage(T message) {
        return message;
    }

}