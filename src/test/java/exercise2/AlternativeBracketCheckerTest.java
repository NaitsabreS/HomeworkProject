package exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class AlternativeBracketCheckerTest {
    AlternativeBracketChecker alternativeBracketChecker = new AlternativeBracketChecker();
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
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = alternativeBracketChecker.alternativeChecker(bracketList);
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
        boolean result = alternativeBracketChecker.alternativeChecker(bracketList);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    void shouldCheckStringHappyPath() throws IOException {
        //given
        String filePath = "src/test/resources/fileForHappyPath";
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = alternativeBracketChecker.alternativeChecker(bracketList);
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
        boolean result = alternativeBracketChecker.alternativeChecker(bracketList);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    void shouldCheckStringFail() throws IOException {
        //given
        String filePath = "src/test/resources/fileFailed";
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = alternativeBracketChecker.alternativeChecker(bracketList);        //then
        Assertions.assertFalse(result);
    }
    @Test
    void shouldCheckStringFailTest2() throws IOException {
        //given
        String filePath = "src/test/resources/fileForTest2";
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = alternativeBracketChecker.alternativeChecker(bracketList);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    void shouldCheckMeanTest() throws IOException {
        //given
        String filePath = "src/test/resources/fileForMeanTest";
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = alternativeBracketChecker.alternativeChecker(bracketList);
        //then
        Assertions.assertTrue(result);
    }
    @Test
    void shouldCheckMeanTest2() throws IOException {
        //given
        String filePath = "src/test/resources/fileForMeanTest2";
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = alternativeBracketChecker.alternativeChecker(bracketList);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    void shouldCheckItself() throws IOException {
        //given
        String filePath = "src/test/resources/fileWithClassCode";
        String input=bracketChecker.buildString(filePath);
        List<Bracket> bracketList = bracketChecker.getListOfBracketsWithIndexes(input);
        //when
        boolean result = alternativeBracketChecker.alternativeChecker(bracketList);
        //then
        Assertions.assertTrue(result);
    }




}