package work.part07.sheets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelectFlight {
    SelenideElement
            type1 = $x("//input[@value='return']"),
            type2 = $x("//input[@value='oneway']");
         //   cityTo = $("#arrivalCity"),
        //    departureDate = $("#departureDate"),
         //   findButton = $x("//button[.='Найти']"),
        //    message = $("#searchMessage");

    @Step("Задание данных рейса")
    public void setFlight(String type_p, String from_p, String to_p, String date1_p, String date2_p) {
        this.type1.click();
        sleep(3_000);
        this.type2.click();
        sleep(3_000);
        this.type1.click();
        sleep(3_000);
        this.type2.click();
        sleep(3_000);
        this.type1.click();
        sleep(3_000);
        this.type2.click();
        sleep(3_000);
        getWebDriver().close();
      //  this.cityFrom.selectOption(from);
       // this.cityTo.selectOption(to);
        //this.findButton.click();
    }
}
