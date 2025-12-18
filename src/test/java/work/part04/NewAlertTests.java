package work.part04;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class NewAlertTests {
    @Test
    void test01_Alert() {    // Алерт с одной кнопкой ОК
        Configuration.pageLoadStrategy = "eager"; //Жадная загрузка
        open("https://demoqa.com/alerts");
       // $("#alert").click();  вариант с CSS селектором
        $x("//button[@id='alertButton']").click(); //Нажимаем на первый алерт
        switchTo()
                .alert()
                .accept();  //Переключаемся на алерт - нажимаем ОК
        sleep(2_000);
        switchTo().defaultContent();   //Возвращаемся на основное окно
        $x("//a[text()='Home']");  // Нажимаем наверху окна
    }

    @Test
    void test02_Alert_Continue() {   // алерт с двумя кнопками Ok и Cancel - нажимаем ОК
        Configuration.pageLoadStrategy = "eager"; //Жадная загрузка
        open("https://demoqa.com/alerts");
        $x("//button[@id='confirmButton']").click(); // Нажимаем на третий алерт(с Confirm)
        Alert alert = switchTo().alert(); //Переключаемся на алерт
        System.out.println(alert.getText()); // Отображает текст из окна
        sleep(10_000);
        alert.accept();  //Нажатие кнопки OK
        sleep(10_000);
        switchTo().defaultContent();   //Возвращаемся на основное окно
        $x("//a[text()='Home']");  // Нажимаем наверху окна
    }

    @Test
    void test03_Alert_Cancel() {     // алерт с двумя кнопками Ok и Cancel - нажимаем Cancel
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/alerts");
        $x("//button[@id='confirmButton']").click();// Нажимаем на третий алерт(с Confirm)
        Alert alert =switchTo().alert(); //Переключились на алерт
        System.out.println(alert.getText());// Отображает текст из окна
        sleep(2_000);
        alert.dismiss();// Нажаите кнопки Cancel
        System.out.println("Нажали отмена");// Отображает текст из окна
        sleep(10_000);
        switchTo().defaultContent(); //выходим из алерта
        $x("//a[text()='Home']");
    }

    @Test
    void test04_Alert_Prompt_OK() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/alerts");
        $x("//button[@id='promtButton']").click();// Нажимаем на третий алерт(с Confirm)
        Alert alert4= switchTo().alert(); //Переключаемся на алерт
        System.out.println(alert4.getText());// Печатаем содержимое окна
        alert4.sendKeys("Произвольный текст");
        sleep(3_000);
        alert4.accept(); // Нажимаем ОК
        sleep(3_000);

        SelenideElement el1 = $x("//span[@id='promptResult']");
        System.out.println(el1.text());

        switchTo().defaultContent(); // Возвращаемся в основное окно
        $x("//a[text()='Home']");
    }

    @Test
    void test05_Alert_Prompt_Cancel() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/alerts");
        $x("//button[@id='promtButton']").click();// Нажимаем на третий алерт(с Confirm)
        Alert alert5 = switchTo().alert(); //Переключаемся на алерт
        alert5.sendKeys("Заполняем текст");
        alert5.dismiss(); // Нажимаем Отмена
        sleep(3_000);
        switchTo().defaultContent(); //Возвращается в основное окно
        $x("//a[text()='Home']");
    }

    /* @Test  ????????????????????????????????????????
    void test06_Alert_Duration() {   /// Уточнить у преподавателя как делать явные задержки в алерте
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/alerts");

        // Имитация задержки 5 секунд
        $x("//button[@id='timerAlertButton']").click();
        sleep(2_000);
        Alert alert = switchTo(Duration.ofSeconds(5)).alert(); //Переключаемся на алерт
        System.out.println(alert.getText()); // Отображает текст из окна
        sleep(10_000);
        alert.accept();  //Нажатие кнопки OK
        sleep(10_000);
        switchTo().defaultContent();   //Возвращаемся на основное окно
        $x("//a[text()='Home']");  // Нажимаем наверху окна
    }
*/
}



