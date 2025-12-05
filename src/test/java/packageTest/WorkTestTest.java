package packageTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WorkTestTest {
    @Test
    void test03() {
       Configuration.browser = "ie";
       Configuration.browserSize = "900x400";
       Configuration.browserPosition = "100x500";
        open("http://92.51.36.108:7777/sl.qa ");
        $("body").shouldHave(text("Учебные приложения"));
        getWebDriver().manage().window().maximize();
        sleep(2000);
    }


 //   @Test
  //      void test04() {
  //          open("http://92.51.36.108:7777/sl.qa");
   //         $("body").shouldHave(text("Промышленные приложения"));
   //     }
    }