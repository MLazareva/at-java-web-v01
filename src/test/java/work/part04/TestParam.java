package work.part04;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestParam {
   // @ParameterizedTest(name = "01. Проверка логинов, #{index}, username:{0}")
    //@ValueSource (strings = "standard_user","locked_out_user","problem_user");

    //public void test01LoginSuccess() {
     //   open("https://slqamsk.github.io/cases/slflights/v01/");


     //   SelenideElement myElement = $("input[name+username]");
     //   $(By.id("username")).sendKeys("standard_user");
    //    $(By.id("password")).type("stand_pass1");
     //   $(By.id("loginButton")).click();
     //   $(By.className("greeting")).shouldHave(text("Добро пожаловать, Иванов Иван Иванович!"));

  //  }

}
