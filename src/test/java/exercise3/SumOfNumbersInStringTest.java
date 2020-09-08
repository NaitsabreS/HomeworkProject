package exercise3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumOfNumbersInStringTest {
    SumOfNumbersInString sumOfNumbersInString = new SumOfNumbersInString();
    @Test
    void shouldSumNumbers() {
//given
        String input1 = "abc123xyz";
        String input2 = "aa11b33";
        String input3 = "7 13";
//when
        int result1 = sumOfNumbersInString.sumOfNumbers(input1);
        int result2 = sumOfNumbersInString.sumOfNumbers(input2);
        int result3 = sumOfNumbersInString.sumOfNumbers(input3);
//then
        Assertions.assertEquals(123, result1);
        Assertions.assertEquals(44, result2);
        Assertions.assertEquals(20, result3);
    }
    @Test
    void shouldSumStringWithoutNumbers() {
//given
        String input1 = "abcsd sa d a syz";
//when
        int result1 = sumOfNumbersInString.sumOfNumbers(input1);
//then
        Assertions.assertEquals(0, result1);
    }
}