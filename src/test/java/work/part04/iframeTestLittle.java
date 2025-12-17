package work.part04;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class iframeTestLittle {
    @Test
    void test01() {
       // Configuration.pageLoadTimeout = 120_000;
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/frames");
        sleep(3000);
        getWebDriver().manage().window().maximize();

        //Делаем скролл до низа окна
        //scrollTo() - проскролить до элемента, чтобы весь iFrame был видет на экране
        // скролим до нижнего элемента на экране, который идет следом за iFrame
       $x("//div[@id='Ad.Plus-970x250-2']").scrollTo(); //для демонстрации
       /// $x("//div[@id='frame2Wrapper']").scrollTo(); //для демонстрации - тоже рабоачая ,как выше строка
        System.out.println("Скролл");
        sleep(5_000);

        //Переключаемся на iFrame1
        switchTo().frame($x("//iframe[@id='frame1']"));
        System.out.println("перешли в рамку");

        //Находим на странице надпись
       // $("#sampleHeading").shouldHave(text("This is a sample page"));   // CSS-селектор
        $x("//h1[contains(.,'This is a sample page')]").shouldBe(exist, Duration.ofSeconds(10));

        System.out.println("нашли надпись");
        sleep(5_000);

        //Выходим из iFrame
        switchTo().defaultContent();//Выходим из iFrame в основное окно
        sleep(5_000);

        //Скролим вверх
        //Щелкаем на верхнем элементе
        //   $x("//div[@class='body-height']").click();  // Тоже рабочая строка - аналог следующей
        $x("//header/a").click();
        System.out.println("перешли наверх страницы");
        sleep(3000);
    }
}
