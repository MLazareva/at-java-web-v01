package demo.part01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
<<<<<<< HEAD
import static org.openqa.selenium.By.cssSelector;
=======
>>>>>>> e8ce9c5cc5d85dc2948904fd574bddf57120dfed

public class SimpleWikiTest {
   // @Test
   // void test01() {
     //   open("https://ru.wikipedia.org/wiki/Selenium");
     //   $("body").shouldHave(text("WebDriver"));
  //  }


    @Test
<<<<<<< HEAD
    void test03() {
     open("https://slqa.ru/cases/SimpleForm");
        sleep(10000);
        open("//ru.wiki");
     $("body").shouldHave(text("Томас Фуллер"));
=======
    void test01() {
        open("https://ru.wikipedia.org/wiki/Selenium");
        $("body").shouldHave(text("WebDriver"));
    }
    @Test
    void test02() {
        open("https://ru.wikipedia.org/wiki/Selenium");
        $("body").shouldHave(text("Selenide"));

        sleep(2000);
>>>>>>> e8ce9c5cc5d85dc2948904fd574bddf57120dfed
    }


 //   @Test
   // void test02() {
    //   open("https://ru.wikipedia.org/wiki/Selenium");
     //   $("body").shouldHave(text("Selenide"));
  // }
}