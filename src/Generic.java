import java.util.ArrayList;
import java.util.List;

public class Generic {

    public static void main(String[] args) {

        welcome("Welcome Player: ", 456);

        var stringPrinter = new Printer<String>();
        stringPrinter.log("string printer");

        var integerPrinter = new Printer<Integer>();
        integerPrinter.log(456);
        System.out.println(integerPrinter.getMessage(456));

        var playerNoList = new ArrayList<Number>();
        playerNoList.add(1);
        playerNoList.add(2);
        playerNoList.add(3);

        var playerNameList = new ArrayList<String>();
        playerNameList.add("John");
        playerNameList.add("Doe");

        var numberPrinter = new Printer<Number>();
        numberPrinter.logFavoritePlayer(playerNoList);
        var textPrinter = new Printer<String>();
        textPrinter.logFavoritePlayer(playerNameList);

        logFavoritePlayer(playerNoList);
        logFavoritePlayer(playerNameList);

    }

    // Generic Method
    private static <Param1, Param2> void welcome(Param1 msg1, Param2 msg2) {
        System.out.println(msg1 + " " + msg2);
    }

    private static <T> void logFavoritePlayer(List<T> players) {
        System.out.println(players);
    }

}

// Generic Class and Methods
class Printer<T> {

    public void log(T message) {
        System.out.println(message);
    }

    public T getMessage(T message) {
        return message;
    }

    public void logFavoritePlayer(List<T> players) {
        System.out.println(players);
    }

}