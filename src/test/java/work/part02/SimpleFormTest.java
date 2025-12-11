package work.part02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.concurrent.locks.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class SimpleFormTest {
    @Test
    public void test01_specific_commands() { // команды Selenide
        open("https://slqa.ru/cases/SimpleForm");
        $(By.id("unique_id")).sendKeys("Тест 100");
        $(By.name("unique_name")).type("Тест 200");
     //   $(By.tagName("blockquote")).shouldBe(Condition.exist);
        $(By.tagName("blockquote")).shouldHave(text("спрашивает"));
     //???   $(By.className("unique_class")).shouldBe(Condition.visible));
        // Ошибка ?   $(By.className("unique_class")).shouldHave(text("При входе в систему возникла ошибка.\nПопробуйте выполнить вход в систему попозже"));
        //   $(By.className("unique_class").shouldBe(visible));
        $(By.className("unique_class")).shouldBe(visible);
    }
    @Test
    public void test02_CSS_selectors() { // команды CSS
        open("https://slqa.ru/cases/SimpleForm");
        $("#unique_id").sendKeys("Тест 300");
        $("[name=unique_name]").type("Тест 400");
        sleep(1_000);
        $("blockquote").shouldHave(text("спрашивает"));
        sleep(1_000);
        $(".unique_class").shouldBe(visible);
        sleep(1_000);
    }
}