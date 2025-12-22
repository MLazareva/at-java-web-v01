package work.part06;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demo.part07.pages.SearchPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import work.part06.sheets.routWindowTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
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
        //  Configuration.pageLoadTimeout= 30_000; // Чтобы успел открыть страницу
       // Configuration.pageLoadStrategy = "eager";  // Жадная загрузка - мы не дожидаемся подгрузки всех ресурсов
       // Configuration.browser = "chrome";  // устанваливаем браузер по умолчанию chrome

      //  open("https://www.aviasales.ru/");
       // getWebDriver().manage().window().maximize();  // Окно на максимум

        // Основаня страница поиска рейсов
        routWindowTest page1 = new routWindowTest();
        page1.searchFlight("Москва","Екатеринбург");
        sleep(3_000);

        //Выберем Шереметьево


    }
}
