package work.part07;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import work.part07.sheets.CardDetails;
import work.part07.sheets.InputLogin;
import work.part07.sheets.PassengerDetails;
import work.part07.sheets.SelectFlight;

import static com.codeborne.selenide.Selenide.*;
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
    void test_022() {  //Позитивный с 3 параметрами в логине
        InputLogin inputLogin = new InputLogin();  // Логинимся с Remember
        inputLogin.loginFunc("agileway", "test$W1se", "1");  // с Remember
        inputLogin.LoginSuccessful();
    }
    @Test
    @Order(3)
    @Disabled
    void test_023() {   // Неверный пароль при входе
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("agileway", "dontremember");
        inputLogin.LoginUnsuccessful();
    }
    @Test
    @Order(4)
    @Disabled
    void test_024() {   // Неверный логин при входе
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("nocorrect", "test$W1se");
        inputLogin.LoginUnsuccessful();
    }
    @Test
    @Order(5)
    @Disabled
    void test_025() {   // Не заданы логин и пароль при входе
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("", "");
        inputLogin.LoginUnsuccessful();
    }
    @Test
    @Order(6)
     @Disabled
    void test_026() {   // Успешная регистрация
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

        try { //Оборачивает в try для удобства проверки ассертов
            selFl.setFlight("New York", "Sydney", "02.08.2026", "1");
            //  город вылета
            //  город прилета
            // дата вылета
            // рейс - от 1-2-3
        } catch (AssertionError error){
            System.err.println("Сообщение #1 об ошибке: "+error.getMessage());
        }

        PassengerDetails passengerData = new PassengerDetails();
        //Проверяем что все данные верно перешли на след.страницу(имя-фамилия)
        try {                                        //Оборачивает в try для удобства проверки ассертов
            passengerData.checkData("New York","Sydney","02.08.2026","1");
        } catch (AssertionError error){
            System.err.println("Сообщение #2 об ошибке: "+error.getMessage());
        }

        // Заполяем имя и фамилию
        passengerData.enterName("Ivan","Ivanov");

        CardDetails cardinfo = new CardDetails();
        //Проверяем что все данные верно перешли на след.страницу(карточка)
        try {
            cardinfo.checkCard("New York","Sydney","1");
        } catch (AssertionError error){
            System.err.println("Сообщение #3 об ошибке: "+error.getMessage());
        }

        //Заполняем данные карточки
        cardinfo.enterDataCard("1", "987654321","05","2025");  // Заполняем данные карточки


        try {
            cardinfo.getConfirmation();     //Подтверждение наличия регистрации на рейс
        } catch (AssertionError error){
            System.err.println("Сообщение #4 об ошибке: "+error.getMessage());
        }

       try {   //Проверяем что все данные в Confirmation верны
            cardinfo.checkConfirmData("New York", "Sydney", "02.08.2026", "1", "Ivan","Ivanov");
            sleep(3000);

        }catch (AssertionError error){
            System.err.println("Сообщение #5 об ошибке: "+error.getMessage());
        }
    }


    @Test
    @Order(8)
    void test_02() {    //Негативный тест - не указали фамилию
        InputLogin inputLogin = new InputLogin();  //Логинимся без Remember
        inputLogin.loginFunc("agileway", "test$W1se");
        inputLogin.LoginSuccessful();

        SelectFlight selFl = new SelectFlight();    //Выбираем рейсы
        //New York - Sedney -  San Francisco
        //New York - Sedney

        try { //Оборачивает в try для удобства проверки ассертов
            selFl.setFlight("New York", "Sydney", "02.08.2026", "1");
            //  город вылета
            //  город прилета
            // дата вылета
            // рейс - от 1-2-3
        } catch (AssertionError error) {
            System.err.println("Сообщение #1 об ошибке для Марины: " + error.getMessage());
        }

        PassengerDetails passengerData = new PassengerDetails();
        //Проверяем что все данные верно перешли на след.страницу
        try {                                        //Оборачивает в try для удобства проверки ассертов
            passengerData.checkData("New York", "Sydney", "02.08.2026", "1");
        } catch (AssertionError error) {
            System.err.println("Сообщение #2 об ошибке для Марины: " + error.getMessage());
        }

        // Заполняем имя и фамилию
        passengerData.enterName("Ivan", "");  //Не указали фамилию
        passengerData.emptyLastName();  //обрабатываем сообщение об ошибке - нет фамилии
        sleep(3000);
    }//   test_02



}
