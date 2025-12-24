package work.part06.sheets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ListOfFlights {

    SelenideElement
            filtr_straight = $x("//div[@data-test-id='set-filter-row-0']"),     // Прямые рейсы
            with_luggage   = $x("//div[@data-test-id='boolean-filter-baggage']"), //С багажом
            luggage20      = $x("//div[@data-test-id='single-choice-filter-baggage_weight-20']"),
            button_Ready   = $x("//button/span[contains(.,'Готово')]");

    @Step("Выбираем без пересадок")
    public void selectStraightFlights() {this.filtr_straight.click();}  // Прямые рейсы


    @Step("Выбираем с багажом 20 кг")
    public void selectWithluggage() {
        this.with_luggage.click();
        this.luggage20.click();
        sleep(3000);
    }

    @Step("Закрываем окно настроек")
    public void closeWindowSettings() { this.button_Ready.click(); }



}
