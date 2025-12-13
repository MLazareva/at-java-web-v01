package work.part02;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.util.concurrent.locks.Condition;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

// @TestMethodOrder(MethodOrderer.MethodName.class) Тесты выполняются в случайном порядке
@TestMethodOrder(MethodOrderer.MethodName.class)   // тесты выполняются согласно сортировке по имени метода test 01-02-03
public class SimpleFormTest {
    @BeforeAll
    static void beforeAll(TestInfo test_info) {
        //   Configuration.browser = Browsers.CHROME;
        //    System.out.println("Тест " + test_info.getDisplayName() + " начали выполнение - Before all");
    }

    @BeforeEach
    void setUp(TestInfo test_info) {
        System.out.println("Тест " + test_info.getDisplayName() + " начали выполнение - Before each");
        //  open("https://slqa.ru/cases/SimpleForm");
        //  sleep(2000);
        //   closeWindow();
    }

    @AfterEach
    void setDown(TestInfo test_info) {
        System.out.println("Тест " + test_info.getDisplayName() + " начали выполнение - After each");
        // open("https://slqamsk.github.io/cases/slflights/v01/");
        //  sleep(2000);
        //   closeWindow();
    }

    @AfterAll
    static void setedge(TestInfo test_info) {
        //    System.out.println("Тест " + test_info.getDisplayName() + " начали выполнение - After all");
        // open("https:////translate.yandex.ru/");
        //     sleep(2000);
        //  closeWindow();
    }

    @Test
    public void test01_specific_commands() { // команды Selenide
        open("https://slqa.ru/cases/SimpleForm");
        $(By.id("unique_id")).sendKeys("Тест 100");
        $(By.name("unique_name")).type("Тест 200");
        //   $(By.tagName("blockquote")).shouldBe(Condition.exist);
        // $(By.tagName("blockquote")).shouldHave(text("спрашивает"));
        //???   $(By.className("unique_class")).shouldBe(Condition.visible));
        // Ошибка ?   $(By.className("unique_class")).shouldHave(text("При входе в систему возникла ошибка.\nПопробуйте выполнить вход в систему попозже"));
        //   $(By.className("unique_class").shouldBe(visible));
        // $(By.className("unique_class")).shouldBe(visible);
    }

    @Test
    public void test02_CSS_selectors() { // команды CSS
        open("https://slqa.ru/cases/SimpleForm");
        $("#unique_id").sendKeys("Тест 300");
        $("[name=unique_name]").type("Тест 400");
        sleep(1_000);
        $("blockquote").shouldHave(text("спрашивает"));
        sleep(1_000);
        $(".unique_class").shouldBe(visible);
        sleep(1_000);
    }

    @Test
    public void test03_XPath()// команды XPath

    {
        open("https://slqa.ru/cases/xPathSimpleForm/");
        $x("//*[@id='unique_id']").sendKeys("Test XPath");
        System.out.println("point1");

        $x("//*[@name='unique_name']").type("Test XPath XPath");
        System.out.println("point2");

        sleep(1_000);
        $x("//cite").shouldHave(text("Томас Фуллер"));
        System.out.println("point3");

        $x("//blockquote").shouldHave(text("Кто ни о чем не спрашивает, тот ничему не научится."));
        System.out.println("point4");

        $x("//p[starts-with(text(),'Кто')]").shouldHave(text("Кто ни о чем не спрашивает, тот ничему не научится."));
        System.out.println("point5");

        $x("//*[@class = 'unique_class']").shouldHave(text("При входе в систему"));
        System.out.println("point6");



        // ???? $x("//*[@class='unique_class']").shouldHave(text("ошибка"));
        //  ???    $x("//*[starts-with(.,'\"При')]").shouldHave(text("ошибка"));
       // ??? $x("//*[starts-with(.,'Показатели')][3]").shouldHave(text("Воронеж"));
        ///  System.out.println("point7");

          $x("//*[starts-with(.,'Казахстан')]").shouldHave(text("площадь 2 724 902"));
         System.out.println("point8");

          $x("//*[starts-with(.,'Россия')]").shouldHave(text("площадь 17 234 031"));
           System.out.println("point9");

        //Дз стр 45

          $(withText("Москва")).shouldHave(text("250 единиц"));   //Selenide
          System.out.println("point10");
          $(byText("Показатели по региону Москва: 250 единиц.")).shouldHave(text("250 единиц"));
          System.out.println("point11");

        // XPath

        //????   $x("//*[text()='Показатели по региону Москва: 250 единиц.']").should(exist);

    //???("//*[text()='Показатели по региону Москва: 250 единиц.']).shouldHave(text("250 единиц."));

       // System.out.println("point12");
        $x("//*[contains(text(),'Показатели по региону Москва: 250 единиц.')]").shouldHave(text("250 единиц"));
        System.out.println("point13");

      //?????  $x("//*[.='Показатели по региону Москва: 250 единиц.']").shouldHave(text("Показатели по региону Москва: 250 единиц."));
     //????  System.out.println("point14");

        $x("//*[contains(.,'Москва')]").shouldHave(text("250 единиц"));
        System.out.println("point15");


         $x("//*[starts-with(.,'Казахстан')]").shouldHave(text("площадь 2 724 902"));
         System.out.println("point16");
         $x("//*[starts-with(text(),'Казахстан')]").shouldHave(text("площадь 2 724 902"));
         System.out.println("point17");

        $x("//*[starts-with(.,'Россия')]").shouldHave(text("площадь 17 234 031"));
        System.out.println("point18");
        $x("//*[starts-with(text(),'Россия')]").shouldHave(text("площадь 17 234 031"));
        System.out.println("point19");

    }

    @Test
    public void test04() {
        //  Configuration.browser = Browsers.CHROME;
        // open("https://slqa.ru/cases/SimpleForm");
        // sleep(2000);
        //  closeWindow();
        sleep(2000);
        System.out.println("Сообщение");
    }

    @Test
    public void test05_TestPageH1() {
        Configuration.browser = Browsers.CHROME;
        open("https://slqamsk.github.io/tmp/xPath01.html");
        //Содержит такой текст
        $x("//h1").shouldHave(text("Учебная страница для XPath"));
        //Точное соответствие
        $x("//h1").shouldHave(exactText("Учебная страница для XPath"));
        sleep(2000);
        System.out.println("Сообщение -  Учебная страница");
    }

    @Test
    public void test06_testSpecialParagraph() {
        Configuration.browser = Browsers.CHROME;
        open("https://slqamsk.github.io/tmp/xPath01.html");
        //Найти параграф с атрибутом class = special-paragraph
        $x("//p[@class='special-paragraph']").shouldHave(exactText("Этот параграф особенный - он единственный на странице с таким классом."));
        $x("//p[@class='info-text'][1]").shouldHave(exactText("Это первый информационный текст."));
        $x("//p[@class='info-text'][2]").shouldHave(exactText("Это второй информационный текст."));
        $x("//p[@class='info-text'][3]").shouldHave(exactText("Это третий информационный текст."));
        sleep(2000);
        System.out.println("Сообщение -  Параграф");
    }

    @Test
    public void test07_ExternalLinks() {
        Configuration.browser = Browsers.CHROME;
        open("https://slqamsk.github.io/tmp/xPath01.html");
        //Найти параграф с атрибутом class = special-paragraph
        $x("//a[@class='external-link'][1]").shouldHave(exactText("Внешняя ссылка (Example)"));
        $x("//a[@class='external-link'][2]").shouldHave(exactText("Внешняя ссылка (Google)"));
        $x("//a[@class='internal-link'][1]").shouldHave(exactText("Внутренняя ссылка (О нас)"));
        sleep(2000);
        System.out.println("Сообщение -  Внешние и внутренние ссылки ссылки");
    }

    @Test
    public void test08_Page42() {
        Configuration.browser = Browsers.CHROME;
        open("http://92.51.36.108:7777/sl.qa/fc/v01/index.php");  //Шаг 1
        sleep(3000);
        back();
        sleep(3000);
        forward();
        sleep(3000);



        $x("//*[@name='sum']").type("100");  // Шаг 2
        System.out.println("point_step2");

        $x("//*[@name='submit']").click();  // Шаг 2
        System.out.println("point_step3");



    }
}
