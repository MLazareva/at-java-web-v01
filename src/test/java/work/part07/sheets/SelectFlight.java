package work.part07.sheets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelectFlight {
    SelenideElement
            typeReturn = $x("//input[@value='return']"),
            typeOneWay = $x("//input[@value='oneway']"),
            cityFrom   = $x("//select[@name='fromPort']"),
            cityTo     = $x("//select[@name='toPort']"),
            day_from   = $x("//select[@id='departDay']"),
            month_year_from = $x("//select[@id='departMonth']"),
            tableFlights = $x("//table[@id='flights']"),
            checkFlight1 = $x("(//input[@type='checkbox'])[1]"),
            checkFlight2 = $x("(//input[@type='checkbox'])[2]"),
            checkFlight3 = $x("(//input[@type='checkbox'])[3]");





    @Step("Проверка, что открыто окно с рейсам")
    void isFlightTable() {    // На форме появилось окно с рейсами
        this.tableFlights
                .shouldBe(visible)
                .shouldHave(text("Time"));
        System.out.println("QWEQEWEWRWERERETRET");
    }

    @Step("Задание данных рейса в одну сторону") //
    public void setFlight(String from_p, String to_p, String date1_p, String flight_p) {  // В одну сторону

        this.typeOneWay.click();   // В одну сторону
        this.cityFrom.selectOption(from_p);  // город вылета
        this.cityTo.selectOption(to_p);     // город прилета

        String str_day = date1_p.substring(0, 2);   // День вылета
        String str_month_year = date1_p.substring(3, 5) + date1_p.substring(6, 10);   // Месяц и год вылета  12.08.2026

        this.day_from.selectOption(str_day);   // день вылета
        this.month_year_from.selectOptionByValue(str_month_year);   // месяц и год вылета

        this.isFlightTable();  // Проверяем что появилось табло с рейсами

        switch(flight_p){
         case "1" -> this.checkFlight1.click();
         case "2" -> this.checkFlight2.click();
         case "3" -> this.checkFlight3.click();
         default -> this.checkFlight1.click();
        };

        sleep(3_000);


        //   getWebDriver().close();

    }


}