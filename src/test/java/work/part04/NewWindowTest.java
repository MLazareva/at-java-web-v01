package work.part04;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WindowType;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class NewWindowTest {

    @Test
    void test01NewWindow() {

        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/");

        //Задаем размеры и позицию окна
        getWebDriver().manage().window().setSize(new Dimension(1000, 1000));
        getWebDriver().manage().window().setPosition(new Point(0, 0));
        sleep(2_000);

        //Создаем новое окно и открывает там сайт
        switchTo().newWindow(WindowType.WINDOW);
        open("https://demoqa.com/");
        // Задаем параметры для второго окна
        getWebDriver().manage().window().setSize(new Dimension(1000, 1000));
        getWebDriver().manage().window().setPosition(new Point(1020, 0));
        sleep(5_000);

        switchTo().window(0);  //переходим снова на первое окно
        $x("//a[text()='Popups']").click(); //Нажимаем кнопку popups
        sleep(5_000);

        switchTo().window(1);  //Переключаемся на второе окно
        $x("//h5[text()='Elements']/parent::*/parent::*").click();

        sleep(5_000);
        closeWindow();
        sleep(5_000);
        switchTo().window(0);
        closeWindow();
        sleep(2_000);
    }

    @Test
    void test02_NewTab() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/");
        getWebDriver().manage().window().maximize();  //открываем максимально
        sleep(2_000);

        switchTo().newWindow(WindowType.TAB);  //создаем новую вкладку
        open("https://demoqa.com/"); //открываем новый сайт

        sleep(2_000);
        switchTo().window(0);  // Переходим на первую вкладку

        $x("//a[text()='Popups']").click(); // Нажимаем на элементе
        sleep(2_000);

        switchTo().window(1);  //Переключаемся на вторую вкладку
        $x("//h5[text()='Elements']/parent::*/parent::*").click(); // Нажимаем на элементе

        sleep(2_000);
        closeWindow(); //Закрываем вторую вкладку
        sleep(2_000);
        switchTo().window(0); //Переходим на первую вкладку
        closeWindow();   //Закрываем вкладку
        sleep(2_000);
    }
}






