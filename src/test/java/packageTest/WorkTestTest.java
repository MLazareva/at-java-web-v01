package packageTest;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WorkTestTest {
    @Test
    void test03() {
        open("http://92.51.36.108:7777/sl.qa ");
        $("body").shouldHave(text("Учебные приложения"));
        sleep(10000);
        // sleep(20000);
    }
        @Test
        void test04() {
            open("http://92.51.36.108:7777/sl.qa");
            $("body").shouldHave(text("Промышленные приложения"));
        }
    }