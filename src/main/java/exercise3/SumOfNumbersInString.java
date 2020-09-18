package exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfNumbersInString {
    public int sumOfNumbers(String input) {
        Pattern pattern = Pattern.compile("[\\-]*[0-9]+");
        Matcher matcher = pattern.matcher(input);
        List<String> listOfStrings = new ArrayList<>();
        while (matcher.find())
        {
            listOfStrings.add(matcher.group(0));
        }
        // this is called 'side-effect' and we should avoid it
        System.out.println(listOfStrings);
        List<String> resultList = new ArrayList<>();
        //clever
        listOfStrings.forEach(word -> resultList.add(word.replaceAll("--", "")));
        return resultList.stream().mapToInt(Integer::parseInt).sum();
    }
}
