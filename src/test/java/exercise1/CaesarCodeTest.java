package exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CaesarCodeTest {
    CaesarCode caesarCode = new CaesarCode();
    @Test
    void shouldEncrypt() {
        //given
        String input = "To zdanie jest zakodowane";
        //when
        String output = caesarCode.encryptOrDecrypt(input);
        //then
        Assertions.assertEquals("Gb mqnavr wrfg mnxbqbjnar",output);
    }
    @Test
    void shouldDecrypt() {
        //given
        String input = "Gb mqnavr wrfg mnxbqbjnar";
        //when
        String output = caesarCode.encryptOrDecrypt(input);
        //then
        Assertions.assertEquals("To zdanie jest zakodowane",output);
    }
    @Test
    void shouldDecryptEmptyString() {
        //given
        String input = "";
        //when
        String output = caesarCode.encryptOrDecrypt(input);
        //then
        Assertions.assertEquals("",output);
    }
    @Test
    void shouldDecryptStringFromWebsite() {
        //given
        String input = "dzis na obiad beda klopsiki";
        //when
        String output = caesarCode.encryptOrDecrypt(input);
        //then
        Assertions.assertEquals("qqmvf an bovnq orqn xybcfvxv",output);
    }
}