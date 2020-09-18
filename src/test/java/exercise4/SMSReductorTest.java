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
    void shouldCountSMS() {
        //given
        String input = "    Podstawowym elementem wzorca jest interfejs Command, deklarujący metodę execute(). Jest to polimorficzna metoda reprezentująca polecenie do wykonania. Metoda ta jest implementowana w klasach ConcreteCommand w postaci polecenia wykonania określonej akcji na obiekcie-przedmiocie Receiver. Klient nie jest bezpośrednio związany ani z obiektem Command, ani z obiektem inicjującym jego wywołanie, czyli Invoker. Widzi jedynie odbiorcę wyników operacji ? obiekt Receiver.";
        SMSReductor smsReductor = new SMSReductor();
        //when
        String result = smsReductor.smsReductionWithoutScanner(input);
        int resultInt = smsReductor.amountOfSMS(result);
        //then
        Assertions.assertEquals("PodstawowymElementemWzorcaJestInterfejsCommand,DeklarującyMetodęExecute().JestToPolimorficznaMetodaReprezentującaPolecenieDoWykonania.MetodaTaJestImplementowanaWKlasachConcreteCommandWPostaciPoleceniaWykonaniaOkreślonejAkcjiNaObiekcie-przedmiocieReceiver.KlientNieJestBezpośrednioZwiązanyAniZObiektemCommand,AniZObiektemInicjującymJegoWywołanie,CzyliInvoker.WidziJedynieOdbiorcęWynikówOperacji?ObiektReceiver.", result);
        Assertions.assertEquals(3, resultInt);

    }

    @Test
    void shouldReduceSMSEmptyMessage() {
        //given
        String input = "";
        SMSReductor smsReductor = new SMSReductor();
        //when
        String result = smsReductor.smsReductionWithStream(input);
        //then
        // what's the count?
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