package work.part02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationTests {
    @Test
    public void test01LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).type("stand_pass1");
        $(By.id("loginButton")).click();
        $(By.id("greeting")).shouldHave(text("Добро пожаловать,"));


        // sleep(2_000);
      /* By myLocator = By.id("submit-button");
        SelenideElement myElement = Selenide.element(myLocator);
        myElement.shouldBe(Condition.visible);

        element(By.id("submit-button")).shouldBe(visible);
        $(By.id("submit-button")).shouldBe(visible);

        $(By.name("interests")).shouldBe(visible);
        $(By.className("nav-link")).shouldBe(visible);
        $(By.tagName("input")).shouldBe(visible);
        $(By.linkText("Регистрация нового пользователя в системе")).shouldBe(visible);
        $(By.partialLinkText("Контакты")).shouldBe(visible);*/
    }

    @Test
    public void test02LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard1_user");
        $(By.id("password")).type("stand1_pass1");
        $(By.id("loginButton")).click();
        $(By.id("message")).shouldHave(text("Неверное имя"));


        sleep(2_000);
    }
}