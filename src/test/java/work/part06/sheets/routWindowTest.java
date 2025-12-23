package work.part06.sheets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;  // Для перевода дня недели на русский
import java.time.format.DateTimeFormatter; // Для перевода дня недели на русский
import java.util.Locale;


import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class routWindowTest {  //Страница - выбор маршрута

    SelenideElement
            cityFrom = $x("//input[@id='avia_form_origin-input']"),
            cityTo   = $x("//input[@id='avia_form_destination-input']"),
            dataTo   = $x("//button[@data-test-id='start-date-field']"),
            dataBack = $x("//button[@data-test-id='end-date-field']"),
            numberOfPassengers = $x("//button[@data-test-id='passengers-field']"),
            buttonFind = $x("//div[@class='s__q0eubYUq5_sOJDEe']/button[@type='button']/div[contains(text(),'Найти билеты')]"),
            buttonAdultPlus = $x("//div[@data-test-id='number-of-adults']" +
            "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='increase-button']"),
            buttonAdultMinus = $x("//div[@data-test-id='number-of-adults']" +
                    "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='decrease-button']"),
            buttonChildPlus = $x("//div[@data-test-id='number-of-children']" +
                    "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='increase-button']"),
            buttonChildMinus = $x("//div[@data-test-id='number-of-children']" +
                    "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='decrease-button']"),
            buttonInfantPlus = $x("//div[@data-test-id='number-of-infants']" +
                    "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='increase-button']"),
            buttonInfantMinus = $x("//div[@data-test-id='number-of-infants']" +
                    "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='decrease-button']"),

            buttonEconom   = $x("//label[@data-test-id='radio-button'][1]"),
            buttonComfort  = $x("//label[@data-test-id='radio-button'][2]"),
            buttonBusiness = $x("//label[@data-test-id='radio-button'][3]"),
            buttonFirst    = $x("//label[@data-test-id='radio-button'][4]"),
            findButton     = $x("//button[@data-test-id='form-submit']");




    ;






    @Step("Поиск рейсов")
    public void searchFlight(String from_param, String to_param, String to_date, String back_date) {

       //----------------- Начало -----Преобразуем даты вылета - прилета  формата 23.12.2025 в вторник, 12 декабря 2025
        // Парсим входящую строку
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date1 = LocalDate.parse(to_date, inputFormatter);  //Дата вылета
        LocalDate date3 = LocalDate.parse(back_date, inputFormatter);  //Дата возврата

        // Форматируем в нужный вид с русской локалью
        // 'EEEE' - полное название дня недели, 'd' - день, 'MMMM' - месяц, 'yyyy' - год
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy");

        String date2 = date1.format(outputFormatter)+" г.";
        String date4 = date3.format(outputFormatter)+" г.";

        System.out.println("Полная дата и день 1: "+ date2.trim());
        System.out.println("Полная дата и день 2: "+ date4.trim());

        // ---------------- Конец--------------------  преобразования даты

        this.cityFrom.click();    // Заводим Откуда
        this.cityFrom.sendKeys(from_param);

        sleep(2_000);    // Заводим Куда
        this.cityTo.sendKeys(to_param);

        sleep(2_000);
        this.dataTo.click();     // Нажимаем на поле даты вылета
        sleep(2_000);

        //Выбираем день из календаря
        String dataStr1 = "//button[@aria-label='"+ date2.trim()+"']";
        String dataStr2 = "//button[@aria-label='"+ date4.trim()+"']";

        $x(dataStr1).click();  // Выбираем дату вылета
        sleep(2_000);

        sleep(2_000);
        this.dataBack.click();     // Нажимаем на поле даты возврата
        sleep(2_000);

        $x(dataStr2).click();  // Выбираем дату возврата
        sleep(2_000);

        sleep(2_000);
        this.numberOfPassengers.click();     // Количество пассажиров
        sleep(2_000);

        this.buttonAdultPlus.click(); // Увиличиваем число взрослых   2
        this.buttonAdultPlus.click(); // Увиличиваем число взрослых
        this.buttonAdultPlus.click(); // Увиличиваем число взрослых
        sleep(2_000);
        this.buttonAdultMinus.click(); // Уменьшаем число взрослых
        this.buttonAdultMinus.click(); // Уменьшаем число взрослых
        sleep(2_000);
        this.buttonChildPlus.click();   //Увеличиваем число детей   1
        this.buttonChildPlus.click();   //Увеличиваем число детей
        this.buttonChildPlus.click();   //Увеличиваем число детей
        this.buttonChildMinus.click();  // Уменьшаем число детей
        this.buttonChildMinus.click();  // Уменьшаем число детей
        sleep(2_000);
        this.buttonInfantPlus.click();  //Увеличиваем число младенцев  1
        this.buttonInfantPlus.click();  //Увеличиваем число младенцев
        this.buttonInfantMinus.click(); //Уменьшаем  число младенцев


        this.buttonComfort.click();   //Радио-кнопка
        sleep(2_000);
        this.buttonBusiness.click();  //Радио-кнопка
        sleep(2_000);
        this.buttonFirst.click();     //Радио-кнопка
        sleep(2_000);
        this.buttonEconom.click();    //Радио-кнопка
        sleep(2_000);






        System.out.println("Дата вылета  ->"+ dataStr1);
        System.out.println("Дата прилета ->"+ dataStr2);

        //



         this.findButton.click();
         sleep(3_000);
    } //Test

} //class
