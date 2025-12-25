package work.part07;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import work.part07.sheets.InputLogin;
import work.part07.sheets.SelectFlight;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)    //Тесты выполняются по номеру order
public class HWSelectFlightTest {
    @BeforeAll
    static void beforeAll() {    // Выполняется перед всеми тестами
        SelenideLogger.addListener("allure", new AllureSelenide());  // Связь с Allure
        Configuration.pageLoadTimeout = 30_000; // Чтобы успел открыть страницу
        Configuration.pageLoadStrategy = "eager";  // Жадная загрузка - мы не дожидаемся подгрузки всех ресурсов
        Configuration.browser = "chrome";  // устанваливаем браузер по умолчанию chrome
       // open("https://travel.agileway.net/");
      //  getWebDriver().manage().window().maximize();  // Окно на максимум
    }
    @BeforeEach
    void beforeEach() {
        open("https://travel.agileway.net/");
        getWebDriver().manage().window().maximize();  // Окно на максимум
    }

    @Test
    @Order(1)
    void test_01() {
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("agileway", "test$W1se");


        SelectFlight selFl = new SelectFlight();
        selFl.setFlight("1", "New York", "Sydney", "02.01.2026", "03.01.2025");


    }

    @Test
    @Order(2)
    void test_02() {
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("agileway", "test$W1se", "1");  // с Remember

        SelectFlight selFl = new SelectFlight();
        selFl.setFlight("1", "New York", "Sydney", "02.01.2026", "03.01.2025");

    }
}
