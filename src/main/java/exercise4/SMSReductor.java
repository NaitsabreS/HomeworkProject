package exercise4;

import java.util.Scanner;

public class SMSReductor {
    private final Scanner scanner = new Scanner(System.in);
    private final StringBuilder stringBuilder = new StringBuilder();

    public void smsReduction() {
        System.out.print("Enter your message: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("");
        } else {
            String[] inputArray = input.split(" ");
            for (String word : inputArray) {
                String firstLetter = word.trim().substring(0, 1).toUpperCase();
                stringBuilder.append(firstLetter);
                stringBuilder.append(word.substring(1));
            }
            System.out.println("Result: " + stringBuilder.toString());
        }
    }

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

    public String smsReductionWithStream(String input) {
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

    public static void main(String[] args) {
        SMSReductor smsReductor = new SMSReductor();
        smsReductor.smsReduction();
    }
}
