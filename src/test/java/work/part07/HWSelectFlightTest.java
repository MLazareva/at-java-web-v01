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

    }
    @BeforeEach
    void beforeEach() {
        open("https://travel.agileway.net/");
        getWebDriver().manage().window().maximize();  // Окно на максимум
    }



    @Test
    @Order(2)
    @Disabled
    void test_02() {  //Позитивный с 3 параметрами в логине
        InputLogin inputLogin = new InputLogin();  // Логинимся с Remember
        inputLogin.loginFunc("agileway", "test$W1se", "1");  // с Remember
        inputLogin.LoginSuccessful();
    }
    @Test
    @Order(3)
    @Disabled
    void test_03() {   // Неверный пароль при входе
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("agileway", "dontremember");
        inputLogin.LoginUnsuccessful();
    }
    @Test
    @Order(4)
    @Disabled
    void test_04() {   // Неверный логин при входе
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("nocorrect", "test$W1se");
        inputLogin.LoginUnsuccessful();
    }
    @Test
    @Order(5)
    @Disabled
    void test_05() {   // Не заданы логин и пароль при входе
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("", "");
        inputLogin.LoginUnsuccessful();
    }
    @Test
    @Order(6)
     @Disabled
    void test_06() {   // Успешная регистрация
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("agileway", "test$W1se");
        inputLogin.LoginSuccessful();
    }

    @Test
    @Order(7)
    void test_01() {    //Позитивный тест
        InputLogin inputLogin = new InputLogin();  //Логинимся без Remember
        inputLogin.loginFunc("agileway", "test$W1se");
        inputLogin.LoginSuccessful();

        SelectFlight selFl = new SelectFlight();    //Выбираем рейсы
        //New York - Sedney -  San Francisco
        //New York - Sedney
        selFl.setFlight("New York", "Sydney", "12.08.2026","1");
         //  город вылета
         //  город прилета
         // дата вылета
         // рейс - от 1-2-3


    }


}
