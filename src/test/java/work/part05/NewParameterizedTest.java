package work.part05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
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
        $x("//input[@name='sum']").setValue(param1); //Задаем сумму
        sleep(2_000);
        $x("//input[@type='submit']").click();
        sleep(2_000);
        $x("//span[@name='com']").shouldHave(exactText(param2)); //проверяем комиссию
    }

    @ParameterizedTest
    @CsvFileSource (resources = "sl_data01.csv", numLinesToSkip = 2)
    void test01(String login, String pass, String fio) {
        open("https://slqamsk.github.io/cases/slflights/v01/");
       // $("#username").sendKeys(login);
        $x("//input[@id='username']").sendKeys(login);

        //$("#password").sendKeys(pass);
        $x("//input[@id='password']").sendKeys(pass);

       // $("#loginButton").click();
        $x("//button[@id='loginButton']").click();

       // $("#logoutButton").shouldBe(visible);
        $x("//button[@id='loginButton']").shouldBe(visible);

     //   $("#greeting").shouldHave(exactText("Добро пожаловать, " + fio + "!"));
        $x("//*[@id='greeting']").shouldHave(exactText("Добро пожаловать, " + fio + "!"));
       // $x("//*[@id='greeting']").shouldHave(text("Добро пожаловать, "));
       // $x("//*[@id='greeting']").shouldHave(text(fio));
       // //$("#greeting").shouldHave(text(fio));
    }
}
