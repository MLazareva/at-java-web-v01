package demo.part01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.cssSelector;

public class SimpleWikiTest {
   // @Test
   // void test01() {
     //   open("https://ru.wikipedia.org/wiki/Selenium");
     //   $("body").shouldHave(text("WebDriver"));
  //  }


    @Test
    void test03() {
     open("https://slqa.ru/cases/SimpleForm");
        sleep(10000);
        open("//ru.wiki");
     $("body").shouldHave(text("Томас Фуллер"));
    }


 //   @Test
   // void test02() {
    //   open("https://ru.wikipedia.org/wiki/Selenium");
     //   $("body").shouldHave(text("Selenide"));
  // }
}