package exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class BracketCheckerTest {
    BracketChecker bracketChecker = new BracketChecker();
    @Test
    void shouldBuildString() throws IOException {
        //given
        String filePath = "src/test/resources/fileForTest1";
        //when
        String result=bracketChecker.buildString(filePath);
        //then
        Assertions.assertEquals("[ to ( jest )]     test", result );

    }

    @Test
    void shouldCheckStringWithoutBrackets() throws IOException {
        //given
        String filePath = "src/test/resources/fileWithoutBrackets";
        // you could write the string in the testcase, so it's easier
        // to understand what's being tested
        String input=bracketChecker.buildString(filePath);
        // design smell, in this case there should be only one public method so
        // the user knows what they can use.
        // Without documentation no one knows in what order methods should be invoked
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = bracketChecker.bracketChecker(bracketList);
        //then
        Assertions.assertTrue(result);
    }
    @Test
    void shouldCheckStringWithOddNumberOfBrackets() throws IOException {
        //given
        String filePath = "src/test/resources/fileWithOddNumberOfBrackets";
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = bracketChecker.bracketChecker(bracketList);
        //then
        Assertions.assertFalse(result);
    }
    // failing test
    @Test
    void shouldCheckStringHappyPath() throws IOException {
        //given
        String filePath = "src/test/resources/fileForHappyPath";
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = bracketChecker.bracketChecker(bracketList);
        //then
        Assertions.assertTrue(result);
    }
    @Test
    void shouldCheckStringHappyPathFailed() throws IOException {
        //given
        String filePath = "src/test/resources/fileForHappyPathFailed";
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = bracketChecker.bracketChecker(bracketList);
        //then
        Assertions.assertFalse(result);
    }
    // failing test
    @Test
    void shouldCheckStringFail() throws IOException {
        //given
        String filePath = "src/test/resources/fileFailed";
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = bracketChecker.bracketChecker(bracketList);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    // Non-descriptive. If it's similar to previous use @ParametrizedTest
    // also failing test
    void shouldCheckStringFailTest2() throws IOException {
        //given
        String filePath = "src/test/resources/fileForTest2";
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = bracketChecker.bracketChecker(bracketList);
        //then
        Assertions.assertFalse(result);
    }

}