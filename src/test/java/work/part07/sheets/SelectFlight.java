package work.part07.sheets;

import com.codeborne.selenide.Configuration;
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
            day_from1   = $x("//select[@id='departDay']"),
            day_from2   = $x("//select[@id='returnDay']"),

            month_year_from1 = $x("//select[@id='departMonth']"),
            month_year_from2 = $x("//select[@id='returnMonth']"),

            tableFlights = $x("//table[@id='flights']"),
            checkFlight1 = $x("(//input[@type='checkbox'])[1]"),
            checkFlight2 = $x("(//input[@type='checkbox'])[2]"),
            checkFlight3 = $x("(//input[@type='checkbox'])[3]"),
            buttonContinue = $x("//input[@type='submit' and @value = 'Continue']");




    @Step("Проверка, что открыто окно с рейсами")
    void isFlightTable() {    // На форме появилось окно с рейсами
        this.tableFlights
                .shouldBe(visible)
                .shouldHave(text("Time"));
        System.out.println("##3 Табло есть");
    }

    public String makeDateCorrect(String date) {
        //Передаём дату в формате DD.MM.YYYY - выдаем в формате YYYY-MM-DD
        if (Configuration.browser == "chrome" && date != null && date.length() == 10) {
            return date.substring(6, 10) + "-" +
                    date.substring(3, 5) + "-" +
                    date.substring(0, 2);
        }
        return date;
    }

    @Step("Задание данных рейса Туда") //
    public void setFlight(String from_p, String to_p, String date1_p, String flight_p) {  // В одну сторону
        //flight_p - время вылета
        this.typeOneWay.click();   // В одну сторону
        this.cityFrom.selectOption(from_p);  // город вылета
        this.cityTo.selectOption(to_p);     // город прилета

        if (date1_p!= null && date1_p.length() == 10) {
            String str_day = date1_p.substring(0, 2);   // День вылета
            String str_month_year = date1_p.substring(3, 5) + date1_p.substring(6, 10);   // Месяц и год вылета  12.08.2026

            this.day_from1.selectOption(str_day);   // день вылета
            this.month_year_from1.selectOptionByValue(str_month_year);   // месяц и год вылета
        }

        this.isFlightTable();  // Проверяем что появилось табло с рейсами


        switch(flight_p){   // Выбираем время рейса
            case "1" -> this.checkFlight1.click();
            case "2" -> this.checkFlight2.click();
            case "3" -> this.checkFlight3.click();
            default -> this.checkFlight1.click();
        }


        this.buttonContinue.click();    // Нажимаем Continue


        System.out.println("##4 ЗАДАЛИ время вылета");
    }

    @Step("Задание данных рейса - Туда-обратно") //
    public void setFlight(String from_p, String to_p,String date1_p, String date2_p, String flight_p) {  // В обе стороны
        // flight_p - время вылета
        this.typeReturn.click();   // В обе стороны
        this.cityFrom.selectOption(from_p);  // город вылета
        this.cityTo.selectOption(to_p);     // город прилета

        if (date1_p!= null && date1_p.length() == 10) {
            String str_day = date1_p.substring(0, 2);   // День вылета
            String str_month_year = date1_p.substring(3, 5) + date1_p.substring(6, 10);   // Месяц и год вылета  12.08.2026

            this.day_from1.selectOption(str_day);   // день вылета
            this.month_year_from1.selectOptionByValue(str_month_year);   // месяц и год вылета
        }

        if (date2_p!= null && date2_p.length() == 10) {
            String str_day = date2_p.substring(0, 2);   // День возвращения
            String str_month_year = date2_p.substring(3, 5) + date2_p.substring(6, 10);   // Месяц и год возвращения  12.08.2026

            this.day_from2.selectOption(str_day);   // день возвращения
            this.month_year_from2.selectOptionByValue(str_month_year);   // месяц и год возвращения
        }

        this.isFlightTable();  // Проверяем что появилось табло с рейсами


        switch(flight_p){    // Задали время вылета
            case "1" -> this.checkFlight1.click();
            case "2" -> this.checkFlight2.click();
            case "3" -> this.checkFlight3.click();
            default -> this.checkFlight1.click();
        }

        this.buttonContinue.click();    // Нажимаем Continue

    }//setFlight
}