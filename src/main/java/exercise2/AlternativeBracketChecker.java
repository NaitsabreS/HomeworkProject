package exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlternativeBracketChecker {
    public boolean alternativeChecker(List<Bracket> listOfBrackets) {
        int temp = 0;
        while (!listOfBrackets.isEmpty()) {
            boolean check = false;
            for (int i = 0; i < listOfBrackets.size() - 1; i++) {
                if (listOfBrackets.get(i).getValue().equals("[")) {
                    // Same as the other BracketChecker - extract method
                    if (listOfBrackets.get(i + 1).getValue().equals("]")) {
                        check = true;
                        temp = i;
                        break;
                    }
                } else if (listOfBrackets.get(i).getValue().equals("{")) {
                    if (listOfBrackets.get(i + 1).getValue().equals("}")) {
                        check = true;
                        temp = i;
                        break;
                    }
                } else if (listOfBrackets.get(i).getValue().equals("(")) {
                    if (listOfBrackets.get(i + 1).getValue().equals(")")) {
                        check = true;
                        temp = i;
                        break;
                    }
                }
            }
            if (check) {
                listOfBrackets.remove(listOfBrackets.get(temp));
                listOfBrackets.remove(listOfBrackets.get(temp));
                alternativeChecker(listOfBrackets);
            } else {
                return false;
            }
        }
        return true;
    }

    public String bracketFormatter(String input) {
        // Overwriting defined variable is a smell. To ensure
        // you're not doing this, make method parameters final
        input = input.replaceAll("\n", "");
        // no need to make it a list, you can iterate over an array
        // with the same syntax
        List<String> splittedInput = Arrays.asList(input.split("(?=[\\[{()}\\]])|(?<=[\\[{()}\\]])"));

        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        for (String string : splittedInput) {
            if (string.startsWith("]") || string.startsWith("}") || string.startsWith(")")) {
                n--;
            }
            stringBuilder.append("\t".repeat(n));
            stringBuilder.append(string);
            stringBuilder.append("\n");
            if (string.startsWith("[") || string.startsWith("{") || string.startsWith("(") ) {
                n++;
            }
        }
        return stringBuilder.toString();
    }
}

