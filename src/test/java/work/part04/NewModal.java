package work.part04;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class NewModal {
    @Test
    void test02_SimpleModal() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/modals/");

        $x("//div[@id = 'popmake-1318']").shouldBe(exist);  // проверяем что модальное
        // окно в принципе есть на странице
        System.out.println("Модальное окно существует");

        $x("//button[@id = 'simpleModal']").click(); //Нажимаем кнопку SimpleModal

        System.out.println("Модальное окно открылось");

        //Открывается модальное окно
        Selenide.sleep(5_000);


        String str1 = "//div[@id='pum-1318']/div[@id = 'popmake-1318']/button[@aria-label='Close']";
        $x(str1).shouldBe(visible)    // проверяем что окно
                .shouldBe(clickable)  //кнопка крестик кликабельна
                .click();             // Нажимаем на крестик - закрывает модальное окно

        System.out.println("Модальное окно закрываем");

        Selenide.sleep(5_000);
        $x("//a[text()='Home']").click();
        Selenide.sleep(5_000);
        System.out.println("Переходим на начало страницы");
    }
}
