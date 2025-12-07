package work.part02;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FeeCalculationTest {
    @Test
    public void testElementSearchMethods() {
     //   open("https://slqa.ru/cases/fc/v01");

     //   sleep(2_000);
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
}