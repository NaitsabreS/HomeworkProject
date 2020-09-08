package exercise4;

import org.hamcrest.Matchers;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;

class SMSReductorTest {
    @Test
    void shouldReduceSMS() {
        //given
        String input = " Dzisiaj jest sobota, imieniny kota";
        SMSReductor smsReductor = new SMSReductor();
        //when
        String result = smsReductor.smsReductionWithoutScanner(input);
        //then
        Assertions.assertEquals("DzisiajJestSobota,ImieninyKota",result);

    }
    @Test
    void shouldReduceSMSEmptyMessage() {
        //given
        String input = "";
        SMSReductor smsReductor = new SMSReductor();
        //when
        String result = smsReductor.smsReductionWithoutScanner(input);
        //then
        Assertions.assertEquals("",result);

    }
}