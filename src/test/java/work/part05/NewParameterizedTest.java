package work.part05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class NewParameterizedTest {
    @ParameterizedTest
    @ValueSource (strings = {"1000","2000", "3000", "тесттест"})
    void test01_parameter(String perem) {                         //Тест с 1 параметром
        open("https://slqa.ru/cases/fc/v01/");
        $x("//input[@name='sum']").setValue(perem);
        sleep(2_000);
        $x("//input[@type='submit']").click();
        sleep(2_000);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "com_test2.csv", numLinesToSkip = 1)
    // numLinesToSkip - сколько строк вначале не обрабатывать как параметры

    void test02_parameter_cvs(String param1, String param2) {
        open("https://slqa.ru/cases/fc/v01/");
        $x("//input[@name='sum']").setValue(param1);
        sleep(2_000);
        $x("//input[@type='submit']").click();
        sleep(2_000);
        $x("//span[@name='com']").shouldHave(text(param2));
    }
}
