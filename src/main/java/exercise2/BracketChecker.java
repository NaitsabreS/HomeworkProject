package exercise2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketChecker {
    StringBuilder stringBuilder = new StringBuilder();

    public String buildString(String filePath) throws IOException {
        List<String> stringLinkedList = Files.readAllLines(Paths.get(filePath));
        for (String line : stringLinkedList) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    public List<Bracket> getListOfBracketsWithIndexes(String input) throws IOException {
        Pattern pattern = Pattern.compile("[\\[{()}\\]]");
        Matcher matcher = pattern.matcher(input);
        List<Bracket> listOfBrackets = new ArrayList<>();
        while (matcher.find()) {
            listOfBrackets.add(new Bracket(matcher.group(0), matcher.start()));
        }
        return listOfBrackets;
    }

    public boolean bracketChecker(List<Bracket> listOfBrackets) {
        while (!listOfBrackets.isEmpty()) {
            boolean returnValue = false;
            if (listOfBrackets.size() % 2 != 0) {
                return false;
            }
            String temp = listOfBrackets.get(0).getValue();
            int endIndex = listOfBrackets.size() - 1;
            if (temp.equals("[")) {
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
            listOfBrackets.remove(0);

            listOfBrackets.remove(endIndex);
            bracketChecker(tempList);

        }
        return true;
    }

    public boolean checkSingleBracket(String bracket, List<Bracket> listOfBrackets) {
        return true;
    }
}
