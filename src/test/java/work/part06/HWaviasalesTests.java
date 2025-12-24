package work.part06;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demo.part07.pages.FlightsListPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import work.part06.sheets.ListOfFlights;
import work.part06.sheets.RoutWindowTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Execution(ExecutionMode.CONCURRENT) // Параллельное выполнение тестов
public class HWaviasalesTests {
    @BeforeAll
    static void beforeAll() {    // Выполняется перед всеми тестами
        SelenideLogger.addListener("allure", new AllureSelenide());  // Связь с Allure
        Configuration.pageLoadTimeout= 30_000; // Чтобы успел открыть страницу
        Configuration.pageLoadStrategy = "eager";  // Жадная загрузка - мы не дожидаемся подгрузки всех ресурсов
        Configuration.browser = "chrome";  // устанваливаем браузер по умолчанию chrome
        open("https://www.aviasales.ru/");
        getWebDriver().manage().window().maximize();  // Окно на максимум
    }


    @Test
    void test01_PageMainTest() {

        // Основаня страница поиска рейсов
        RoutWindowTest page1 = new RoutWindowTest();
        // Число пассажиров - не более 9 в сумме
        page1.searchFlight("Москва","Екатеринбург","08.01.2026",
                "09.01.2026", 1,1,0,1);

        sleep(30_000);


        // Страница со списком найденных рейсов
        //ListOfFlights flightsList = new ListOfFlights();
         // flightsList.selectStraightFlights();   // Выбираем прямые рейсы

       // sleep(30_000);
       // flightsList.selectWithluggage();       // Выбираем рейсы с багажом
      //  flightsList.closeWindowSettings();     //Закрываем настройки





    }
}
