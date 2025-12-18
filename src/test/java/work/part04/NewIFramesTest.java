package work.part04;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class NewIFramesTest {
    @Test
    void test01IFrame() {
        //Configuration.pageLoadTimeout = 120_000; // Пробовали увеличивать время, но она не догружается
        Configuration.pageLoadStrategy = "eager"; // Жадная загрузка
        //   Configuration.browserSize = "500x500";
        //  Configuration.browserPosition = "100X200";
        open("https://practice-automation.com/iframes/"); // Страница с двумя iFrame
        sleep(3_000);

        getWebDriver().manage().window().maximize();// Открываем страницу на весь экран

        //scrollTo() - проскролить до элемента, чтобы весь iFrame был видет на экране
        // скролим до нижнего элемента на экране, который идет следом за iFrame
          $x("//*[@class='wp-block-spacer'][2]").scrollTo(); //для демонстрации
        // Это для большого разрешения экрана - для маленького эта команда все портит
        // можно вместо wp-block.. использовать другую строку #footer или задать разрешение экрана browserSize выше
       // $("#footer").scrollTo();//проскроливает до подвала
        sleep(5_000);

        //Переключаемся на второй iFrame
        switchTo().frame($x("//div[@class='entry-content']/iframe[@id='iframe-2']"));
        // Другой вариант нахождения - тоже работает
       /// switchTo().frame($x("//iframe[@id='iframe-2']"));
        //Далее работаем на той странице, которая внутри iFrame
        //Переходим в меню About/About Selenium
        $x("//p/a[contains(.,'About')]").click(); //Нажимаем на меню
        sleep(5_000);
        $x("//p/a[contains(.,'About Selenium')]").click();  //Нажимаем на меню
        sleep(5_000);

        switchTo().defaultContent();//Выходим из iFrame в основное окно
        $x("//body").scrollTo(); //для демонстрации - скролим до верха страницы
        sleep(5_000);
        $x("//a[text()='Home']").click();//Кликаем по ссылке Home
        sleep(10_000);
    }
}