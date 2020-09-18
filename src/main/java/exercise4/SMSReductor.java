package exercise4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SMSReductor {
    // reductor should take a string, scanner should be used elsewhere
    private final Scanner scanner = new Scanner(System.in);
    // again, one string builder for all invocations
    private final StringBuilder stringBuilder = new StringBuilder();

    public void smsReduction() {
        System.out.print("Enter your message: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            // it should just return reduced SMS, this class shouldn't write to console
            System.out.println("");
        } else {
            String[] inputArray = input.split(" ");
            for (String word : inputArray) {
                String firstLetter = word.trim().substring(0, 1).toUpperCase();
                stringBuilder.append(firstLetter);
                stringBuilder.append(word.substring(1));
            }
            System.out.println("Amount of messages: " + amountOfSMS(stringBuilder.toString()));
            System.out.println("Result: " + stringBuilder.toString());
        }
    }

    // I bet you wrote this so you can write tests ;)
    public String smsReductionWithoutScanner(String input) {
        if (input.isEmpty()) {
            return "";
        }
        String[] inputArray = input.trim().split(" ");
        for (String word : inputArray) {
            String firstLetter = word.trim().substring(0, 1).toUpperCase();
            stringBuilder.append(firstLetter);
            stringBuilder.append(word.substring(1));
        }
        return stringBuilder.toString();
    }

    public int amountOfSMS(String input) {
        return input.length()/160+1;
    }

    // if you're doing the same in different ways, create an interface
    // with multiple implementations
    public String smsReductionWithStream(String input) {
        if (input.isEmpty()) {
            return "";
        }
        Arrays.stream(input.trim().split(" ")).forEach(word->{
            stringBuilder.append(word.trim().substring(0, 1).toUpperCase());
            stringBuilder.append(word.substring(1));
        });
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SMSReductor smsReductor = new SMSReductor();
        smsReductor.smsReduction();
    }
}
