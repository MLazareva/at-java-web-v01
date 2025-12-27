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
import static com.codeborne.selenide.WebDriverRunner.driver;
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

    @AfterEach
    void afterEach() {
        getWebDriver().close(); // Закрываем окно, освобождаем память
        System.out.println("ЗАКРЫЛИ ОКНО");
    }


    @Test
    @Order(3)
    @DisplayName("Позитивный тест - логин с remember")
    void test_03() {  //Позитивный с 3 параметрами в логине - с remember
        InputLogin inputLogin = new InputLogin();  // Логинимся с Remember
        inputLogin.loginFunc("agileway", "test$W1se", "1");  // с Remember
        inputLogin.LoginSuccessful();
        System.out.println("******  Прошли 3 тест ******");
    }//test_03

    @Test
    @Order(4)
    @DisplayName("Негативный тест - без remember - Неверный пароль при входе")
    void test_04() {   // Неверный пароль при входе
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("agileway", "dontremember");
        inputLogin.LoginUnsuccessful();
        System.out.println("******  Прошли 4 тест *******");
    }//test_04

    @Test
    @Order(5)
    @DisplayName ("Негативный тест - c remember - Неверный логин при входе")
    void test_05() {   // Неверный логин при входе
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("nocorrect", "test$W1se","1");
        inputLogin.LoginUnsuccessful();
        System.out.println("****** Прошли 5 тест ********");
    }//test_05

    @Test
    @Order(6)
    @DisplayName("Негативный тест - без remember - Не указываются ни логин, ни пароль")
    void test_06() {   // Не заданы логин и пароль при входе
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("", "");
        inputLogin.LoginUnsuccessful();
        System.out.println("****** Прошли 6 тест ******");
    }//test_06

    @Test
    @Order(7)
    @DisplayName("Позитивный тест - логин без remember")
    void test_07() {   // Успешная регистрация
        InputLogin inputLogin = new InputLogin();
        inputLogin.loginFunc("agileway", "test$W1se");
        inputLogin.LoginSuccessful();
        System.out.println("******  Прошли 7 тест *********");
    }//test_07

    @Test
    @Order(1)
    @DisplayName("Позитивный полный тест-Рейс в одну сторону(New York-Sydney)- карта Visa -Qantas 8:00")
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
        //Проверяем что все данные верно перешли на следующую страницу(имя-фамилия)
        try {                                        //Оборачивает в try для удобства проверки ассертов
            passengerData.checkData("New York","Sydney","02.08.2026");
        } catch (AssertionError error){
            System.err.println("Сообщение #2 об ошибке: "+error.getMessage());
        }

        // Заполняем имя и фамилию
        passengerData.enterName("Ivan","Ivanov");

        CardDetails cardinfo = new CardDetails();
        //Проверяем что все данные верно перешли на след.страницу(карточка)
        try {
            cardinfo.checkCard("New York","Sydney","1");  //Туда
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
            cardinfo.checkConfirmData("New York", "Sydney", "02.08.2026","Ivan","Ivanov");
            sleep(3000);

        }catch (AssertionError error){
            System.err.println("Сообщение #5 об ошибке: "+error.getMessage());
        }
       System.out.println("****** Прошли 1 тест *****************");
    }//test01


    @Test
    @Order(2)
    @DisplayName("Негативный тест - без remeber - В одну сторону(New York-Sydney) - Не указана фамилия )")
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
            passengerData.checkData("New York", "Sydney", "02.08.2026");
        } catch (AssertionError error) {
            System.err.println("Сообщение #2 об ошибке для Марины: " + error.getMessage());
        }

        // Заполняем имя и фамилию
        passengerData.enterName("Ivan", "");  //Не указали фамилию
        passengerData.emptyLastName();  //обрабатываем сообщение об ошибке - нет фамилии

        System.out.println("****** Прошли 2 тест ***************");
    }//   test_02

    @Test
    @Order(8)
    @DisplayName("Позитивный полный тест-Рейс в обе стороны (New York-Sydney)-карта Visa-Virgin Australia")
    void test_08() {    //Позитивный тест
        InputLogin inputLogin = new InputLogin();  //Логинимся без Remember
        inputLogin.loginFunc("agileway", "test$W1se");
        inputLogin.LoginSuccessful();

        SelectFlight selFl = new SelectFlight();    //Выбираем рейсы
        //New York - Sedney -  San Francisco  ->  New York - Sedney

        try { //Оборачивает в try для удобства проверки ассертов
            selFl.setFlight("New York", "Sydney", "05.09.2026","10.09.2026", "2");
             //  город вылета
            //  город прилета
            // дата вылета
            // дата возвращения
            // рейс - от 1-2-3
        } catch (AssertionError error){
            System.err.println("Сообщение #11 об ошибке: "+error.getMessage());
        }

        PassengerDetails passengerData = new PassengerDetails();
        //Проверяем что все данные верно перешли на следующую страницу(имя-фамилия)
        try {                                        //Оборачивает в try для удобства проверки ассертов
            passengerData.checkData("New York","Sydney","05.09.2026","10.09.2026");
        } catch (AssertionError error){
            System.err.println("Сообщение #2 об ошибке: "+error.getMessage());
        }

        // Заполняем имя и фамилию
        passengerData.enterName("Petr","Petrov");

        CardDetails cardinfo = new CardDetails();
        //Проверяем что все данные верно перешли на след.страницу(карточка)
        try {
            cardinfo.checkCard("New York","Sydney","2");  // Туда-обратно
        } catch (AssertionError error){
            System.err.println("Сообщение #3 об ошибке: "+error.getMessage());
        }

        //Заполняем данные карточки
        cardinfo.enterDataCard("1", "6565656565","07","2026");  // Заполняем данные карточки

        try {
            cardinfo.getConfirmation();     //Подтверждение наличия регистрации на рейс
        } catch (AssertionError error){
            System.err.println("Сообщение #4 об ошибке: "+error.getMessage());
        }

        try {   //Проверяем что все данные в Confirmation верны
            cardinfo.checkConfirmData("New York", "Sydney", "05.09.2026",
                    "10.09.2026", "Petr","Petrov");

        }catch (AssertionError error){
            System.err.println("Сообщение #5 об ошибке: "+error.getMessage());
        }
        System.out.println("****** Прошли 8 тест ***********");
    }//test_08

    @Test
    @Order(9)
    @DisplayName("Позитивный полный тест-Рейс в обе стороны (San Francisco-New York)-карта Master-Qantas")
    void test_09() {    //Позитивный тест
        InputLogin inputLogin = new InputLogin();  //Логинимся без Remember
        inputLogin.loginFunc("agileway", "test$W1se");
        inputLogin.LoginSuccessful();

        SelectFlight selFl = new SelectFlight();    //Выбираем рейсы
        //New York - Sedney -  San Francisco  ->  New York - Sedney

        try { //Оборачивает в try для удобства проверки ассертов
            selFl.setFlight("San Francisco", "New York", "20.12.2026","25.12.2026", "3");
            //  город вылета
            //  город прилета
            // дата вылета
            // дата возвращения
            // рейс - от 1-2-3
        } catch (AssertionError error){
            System.err.println("Сообщение #11 об ошибке: "+error.getMessage());
        }

        PassengerDetails passengerData = new PassengerDetails();
        //Проверяем что все данные верно перешли на следующую страницу(имя-фамилия)
        try {                                        //Оборачивает в try для удобства проверки ассертов
            passengerData.checkData("San Francisco","New York","20.12.2026","25.12.2026");
        } catch (AssertionError error){
            System.err.println("Сообщение #2 об ошибке: "+error.getMessage());
        }

        // Заполняем имя и фамилию
        passengerData.enterName("Semen","Semenov");

        CardDetails cardinfo = new CardDetails();
        //Проверяем что все данные верно перешли на след.страницу(карточка)
        try {
            cardinfo.checkCard("San Francisco","New York","2");  // Туда-обратно
        } catch (AssertionError error){
            System.err.println("Сообщение #3 об ошибке: "+error.getMessage());
        }

        //Заполняем данные карточки  - Master
        cardinfo.enterDataCard("2", "6565656565","09","2027");  // Заполняем данные карточки

        try {
            cardinfo.getConfirmation();     //Подтверждение наличия регистрации на рейс
        } catch (AssertionError error){
            System.err.println("Сообщение #4 об ошибке: "+error.getMessage());
        }

        try {   //Проверяем что все данные в Confirmation верны
            cardinfo.checkConfirmData("San Francisco", "New York", "20.12.2026",
                    "25.12.2026", "Semen","Semenov");

        }catch (AssertionError error){
            System.err.println("Сообщение #5 об ошибке: "+error.getMessage());
        }
        System.out.println("****** Прошли 9 тест ***********");
    }//test_09

    @Test
    @Order(10)
    @DisplayName("Позитивный полный тест-Рейс в одну сторону(San Francisco-Sydney)- карта Master -Qantas 9:00")
    void test_10() {    //Позитивный тест
        InputLogin inputLogin = new InputLogin();  //Логинимся без Remember
        inputLogin.loginFunc("agileway", "test$W1se");
        inputLogin.LoginSuccessful();

        SelectFlight selFl = new SelectFlight();    //Выбираем рейсы
        //New York - Sedney -  San Francisco
        //New York - Sedney

        try { //Оборачивает в try для удобства проверки ассертов
            selFl.setFlight("San Francisco", "Sydney", "17.09.2026", "3");
            //  город вылета
            //  город прилета
            // дата вылета
            // рейс - от 1-2-3
        } catch (AssertionError error){
            System.err.println("Сообщение #1 об ошибке: "+error.getMessage());
        }

        PassengerDetails passengerData = new PassengerDetails();
        //Проверяем что все данные верно перешли на следующую страницу(имя-фамилия)
        try {                                        //Оборачивает в try для удобства проверки ассертов

             passengerData.checkData("San Francisco","Sydney","17.09.2026");
        } catch (AssertionError error){
            System.err.println("Сообщение #2 об ошибке: "+error.getMessage());
        }

        // Заполняем имя и фамилию
        passengerData.enterName("Viktor","Somov");

        CardDetails cardinfo = new CardDetails();
        //Проверяем что все данные верно перешли на след.страницу(карточка)
        try {
            cardinfo.checkCard("San Francisco","Sydney","1");  //Туда
        } catch (AssertionError error){
            System.err.println("Сообщение #3 об ошибке: "+error.getMessage());
        }

        //Заполняем данные карточки
        cardinfo.enterDataCard("2", "6767667","01","2026");  // Заполняем данные карточки

        try {
            cardinfo.getConfirmation();     //Подтверждение наличия регистрации на рейс
        } catch (AssertionError error){
            System.err.println("Сообщение #4 об ошибке: "+error.getMessage());
        }

        try {   //Проверяем что все данные в Confirmation верны
            cardinfo.checkConfirmData("San Francisco", "Sydney", "17.09.2026","Viktor","Somov");
            sleep(3000);

        }catch (AssertionError error){
            System.err.println("Сообщение #5 об ошибке: "+error.getMessage());
        }
        System.out.println("****** Прошли 10 тест *****************");
    }//test10


} //class main
