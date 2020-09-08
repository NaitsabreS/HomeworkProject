package exercise3;

import java.util.Arrays;
import java.util.List;

public class SumOfNumbersInString {
    public int sumOfNumbers(String input) {
        List<String> listOfStrings = Arrays.asList(input.trim().toLowerCase().split("[^0-9]+"));
        System.out.println(listOfStrings);
        return listOfStrings.stream().filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).sum();
    }

}
