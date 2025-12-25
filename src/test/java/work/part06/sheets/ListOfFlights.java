package work.part06.sheets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.*;

public class ListOfFlights {

    SelenideElement
            filter_straight = $x("//div[@data-test-id='set-filter-row-0']//input[@type='checkbox']"),     // Прямые рейсы
            with_luggage   = $x("//div[@data-test-id='boolean-filter-baggage']"), //С багажом
            luggage20      = $x("//div[@data-test-id='single-choice-filter-baggage_weight-20']"),
            button_Ready   = $x("//button/span[contains(.,'Готово')]");

    @Step("Выбираем рейсы без пересадок")
    public void selectStraightFlights() {
      //  $x("//div[@data-test-id='ticket-preview']//span[contains(.,'Оптимальный')]").click();
        switchTo().window(0);
        this.with_luggage.click();
        sleep(10_000);
        //switchTo().window(0);

        // $x("//div[@data-test-id='text']/span[contains(text(),'Длительность пересадок')]").scrollTo();
        //button[@data-test-id='later-dialog-button']   Позже
        // this.filter_straight.click();}  // Прямые рейсы
    }

    @Step("Выбираем с багажом 20 кг")
    public void selectWithluggage() {
        this.with_luggage.click();
        this.luggage20.click();
        sleep(3000);
    }

    @Step("Закрываем окно настроек")
    public void closeWindowSettings() { this.button_Ready.click(); }



}
