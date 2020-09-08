package exercise4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SMSReductorTest {
    @Test
    void shouldReduceSMS() {
        //given
        String input = " Dzisiaj jest sobota, imieniny kota";
        SMSReductor smsReductor = new SMSReductor();
        //when
        String result = smsReductor.smsReductionWithoutScanner(input);
        //then
        Assertions.assertEquals("DzisiajJestSobota,ImieninyKota", result);

    }

    @Test
    void shouldReduceSMSEmptyMessage() {
        //given
        String input = "";
        SMSReductor smsReductor = new SMSReductor();
        //when
        String result = smsReductor.smsReductionWithStream(input);
        //then
        Assertions.assertEquals("", result);
    }

    @Test
    void shouldReduceSMSWithStream() {
        //given
        String input = " Dzisiaj jest sobota, imieniny kota";
        SMSReductor smsReductor = new SMSReductor();
        //when
        String result = smsReductor.smsReductionWithoutScanner(input);
        //then
        Assertions.assertEquals("DzisiajJestSobota,ImieninyKota", result);
    }
}