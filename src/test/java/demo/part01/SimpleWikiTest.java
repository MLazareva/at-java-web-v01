package demo.part01;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SimpleWikiTest {
    @Test
    void test01() {
        open("https://ru.wikipedia.org/wiki/Selenium");
        $("body").shouldHave(text("WebDriver"));
        sleep(10000);
        sleep(20000);
    }



    @Test
    void test02() {
        open("https://ru.wikipedia.org/wiki/Selenium");
        $("body").shouldHave(text("Selenide"));
    }
}