package work.part05;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class HWTicketTest {
   // Для формы расчёта стоимости билета в кино: http://92.51.36.108:7777/sl.qa/cinema/index.php
    // напишите минимум 5 тест-кейсов и автоматизируйте их любым доступным вам способом.
    // Требования к форме см. на этом слайде:
    // https://docs.google.com/presentation/d/1QwFokl3ghAUMXWeiCRO5oILF4Hcznrq60-pyP13Xfxw/edit?slide=id.g34b94a5208e_0_0#slide=id.g34b94a5208e_0_0
   static void beforeAll() {
       Configuration.pageLoadTimeout= 30_000; // Чтобы успел открыть страницу
       Configuration.pageLoadStrategy = "eager";  // Жадная загрузка - мы не дожидаемся подгрузки всех ресурсов
       // Идем дальше, как только загрузился html
   }
   // Дата: {1} Время: {2} Фильм: {3} Результат: {4}
    @ParameterizedTest(name = "Тест №  #{index} Возраст: {0} Дата: {1} Время: {2} Фильм: {3} Результат: {4}")
    @CsvFileSource(resources = "ticket_data.csv", numLinesToSkip = 1)
    void test02_ticket_HW(String age, String date, String time1,  String film1, String rezult1) {
       open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
       sleep(2_000);

       $x("//input[@name='age']").sendKeys(age);
       sleep(2_000);
       System.out.println("Задали возраст");

       $x("//input[@name='date']").sendKeys(date);
       sleep(2_000);
       System.out.println("Задали дату");

       String str1 ="//input[@type='radio' and @name='session' and @value="+time1+"]";
       // "//input[@type='radio' and @name='session' and @value= time1]"

        System.out.println(str1);

        $x(str1).click();
       sleep(2_000);
       System.out.println("Выбрали время");

    /*  String str2 = "";  // ????? Почему подчеркивает str2

        if (Objects.equals(film1, "1")) {
                      str2 ="//input[@type='radio' and @name='film' and @value=\"back\"]";
            System.out.println(str2);
        }
        if (Objects.equals(film1, "2")) {
             str2 ="//input[@type='radio' and @name='film' and @value=\"crime\"]";
            System.out.println(str2);
        }

        if (Objects.equals(film1, "3")) {
             str2 ="//input[@type='radio' and @name='film' and @value=\"king\"]";
            System.out.println(str2);
        }
        if (Objects.equals(film1, "4")) {
             str2 ="//input[@type='radio' and @name='film' and @value=\"killers\"]";
            System.out.println(str2);
        }

        if (Objects.equals(film1, "5")) {
             str2 ="//input[@type='radio' and @name='film' and @value=\"tango\"]";
            System.out.println(str2);
        }

        $x(str2).click();
*/

        String str3 = "//input[@type='radio' and @name='film']"+"["+film1+"]";
        System.out.println(str3);

        $x(str3).click();
        sleep(2_000);
        System.out.println("Выбрали фильм");

///  Не работает нажатие на кнопку Рассчитать

        $x("//input[@value='Рассчитать']").shouldBe(visible)
                        .click();


      //  $x("//input[@type='submit' and @value='Рассчитать']").shouldBe(exist,Duration.ofSeconds(10));
     //   $x("//input[@type='submit' and @value='Рассчитать']").click();

        sleep(2_000);
        System.out.println("Нажали кнопку Рассчитать");

        //String s1 = "//div[contains.,'"+ rezult1+"']";

        System.out.println(rezult1);
       // String s1 = "//div"

        SelenideElement se1 =$x("//div");
        System.out.println(se1.getTagName());
        System.out.println(se1.text());

        // Убедимся, что это h3 (имя тега), еще имя и класс
      //  System.out.println("Элемент с названием пиццы. Тег:" + se1.getTagName() + ", текст: "+ se1.text());

       // $x("//div[contains(.,'Стоимость билета')]").shouldBe(exist, Duration.ofSeconds(10));

        sleep(2_000);
       // System.out.println(rezult1);
    }
}
