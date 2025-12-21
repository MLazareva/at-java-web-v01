package work.part06;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class test01_Test {
@BeforeAll
    static void beforeAll() {
        Configuration.pageLoadTimeout= 30_000; // Чтобы успел открыть страницу
        Configuration.pageLoadStrategy = "eager";  // Жадная загрузка - мы не дожидаемся подгрузки всех ресурсов
        // Идем дальше, как только загрузился html
        Configuration.browser ="chrome";

    }
    @Test
    void test01_Plane() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        sleep(2_000);
        $x("//input[@id='username']").sendKeys("standard_user");
        sleep(2_000);
        $x("//input[@id='password']").sendKeys("stand_pass1");
        sleep(2_000);
        $x("//button[@id='loginButton']").click();
        sleep(20_000);
    }
}
