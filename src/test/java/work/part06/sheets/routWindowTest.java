package work.part06.sheets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class routWindowTest {  //Страница - выбор маршрута
    SelenideElement
            cityFrom = $x("//input[@id='avia_form_origin-input']"),
            cityTo  = $x("//input[@id='avia_form_destination-input']"),
            dataTo = $x("//div[@class='s__tI_AOcPHWQjaIcGs']/div[@data-test-id='start-date-value']"),
            dataBack = $x("//div[@class='s__tI_AOcPHWQjaIcGs']/div[@data-test-id='end-date-value']"),
            numberOfPassengers = $x("//div[@data-test-id='passenger-numbers']"),
            buttonFind = $x("//div[@class='s__q0eubYUq5_sOJDEe']/button[@type='button']/div[contains(text(),'Найти билеты')]");





    @Step("Поиск рейсов")
    public void searchFlight(String from_param, String to_param) {//String departureDate, String from, String to

     //   this.cityFrom.click();
       // this.cityTo.sendKeys("");
     //   this.cityTo.sendKeys(to_param);
//sleep(2_000);
        this.cityFrom.click();
      //  this.cityFrom.sendKeys("");
        this.cityFrom.sendKeys(from_param);
sleep(2_000);
        this.cityTo.sendKeys(to_param);
        sleep(2_000);

        // this.departureDate.setValue(makeDateCorrect(departureDate));
      //  this.cityFrom.click();
       // this.cityFrom.sendKeys("");
       // this.cityFrom.sendKeys(Keys.CONTROL +"a");
      //  this.cityFrom.sendKeys(Keys.DELETE);


       // this.cityFrom.sendKeys(from_param);
       // this.cityTo.sendKeys("");
      //  this.cityFrom.click();
       // this.cityTo.sendKeys(to_param);
      //  this.cityTo.sendKeys("");
     //   this.cityFrom.click();
       // this.cityFrom.sendKeys(from_param);

       // this.findButton.click();
    }





}
