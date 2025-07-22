package hackerrank;

import java.util.Scanner;

public class ConsoleInput {

    public static void main(String[] args) {

        try (var inputStream = new Scanner(System.in)) {
            /*
                the program waits for input indefinitely (because it's expecting EndOfFile)
                Ctrl+D to manually stop the program / pass wrong input
            */
            while (inputStream.hasNext()) { // OR for (int i=0; i<3; i++)
                var text = inputStream.next();
                var number = inputStream.nextInt();
                System.out.println(text + " - " + number);
            }
        } catch (Exception ex) {
            System.out.println("unexpected/wrong input");
            // ex.printStackTrace();
        }

    }

}
