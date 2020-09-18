package exercise2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
// unused import
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketChecker {
    // Same as in caesar code, next invocation builds on previous one
    StringBuilder stringBuilder = new StringBuilder();

    //this is not this class' responsibility
    public String buildString(String filePath) throws IOException {
        // there's a method for that
        // return Files.readString(Paths.get(filePath));
        List<String> stringLinkedList = Files.readAllLines(Paths.get(filePath));
        for (String line : stringLinkedList) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    public List<Bracket> getListOfBracketsWithIndexes(String input) throws IOException /*never thrown*/{
        Pattern pattern = Pattern.compile("[\\[{()}\\]]");
        Matcher matcher = pattern.matcher(input);
        List<Bracket> listOfBrackets = new ArrayList<>();
        while (matcher.find()) {
            listOfBrackets.add(new Bracket(matcher.group(0), matcher.start()));
        }
        return listOfBrackets;
    }

    // method name should be a verb and should indicate what's to
    // expect as an output
    // e.g. public boolean bracketsMatch(String input)
    // or public boolean hasMatchingBrackets(String input)
    public boolean bracketChecker(List<Bracket> listOfBrackets) {
        while (!listOfBrackets.isEmpty()) {
            boolean returnValue = false;
            if (listOfBrackets.size() % 2 != 0) { // failing fast, very good
                return false;
            }
            String temp = listOfBrackets.get(0).getValue();
            int endIndex = listOfBrackets.size() - 1;
            if (temp.equals("[")) {
                // those three loops are identical.
                // Should have been extracted to a method.
                // If you're unsure how to return multiple values,
                // simply enclose them in a new class.
                for (int i = 1; i < listOfBrackets.size(); i++) {
                    if (listOfBrackets.get(i).getValue().equals("]")) {
                        endIndex = i;
                        returnValue = true;
                        break;
                    }
                }
            } else if (temp.equals("{")) {
                for (int i = 1; i < listOfBrackets.size(); i++) {
                    if (listOfBrackets.get(i).getValue().equals("}")) {
                        endIndex = i;
                        returnValue = true;
                        break;
                    }
                }
            } else if (temp.equals("(")) {
                for (int i = 1; i < listOfBrackets.size(); i++) {
                    if (listOfBrackets.get(i).getValue().equals(")")) {
                        endIndex = i;
                        returnValue = true;
                        break;
                    }
                }
            } else {
                return false;
            }
            if (!returnValue) {
                return false;
            }
            List<Bracket> tempList = List.copyOf(listOfBrackets);
            if (endIndex > 1) {
                tempList=tempList.subList(1, endIndex);
            }
            // you don't need to remove anything, you're passing further different list
            listOfBrackets.remove(0);
            listOfBrackets.remove(endIndex);
            // nice idea
            bracketChecker(tempList);
        }
        return true;
    }

    // unused code
    public boolean checkSingleBracket(String bracket, List<Bracket> listOfBrackets) {
        return true;
    }
}
