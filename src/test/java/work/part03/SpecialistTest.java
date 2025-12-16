package work.part03;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.pageLoadStrategy;
import static com.codeborne.selenide.Selenide.*;

public class SpecialistTest {
   @BeforeAll
   static void beforeAll() {
        Configuration.pageLoadTimeout= 30_000; // Чтобы успел открыть страницу
        Configuration.pageLoadStrategy = "eager";  // Жадная загрузка - мы не дожидаемся подгрузки всех ресурсов
       // Идем дальше, как только загрузился html
   }
    //На сайте https://specialist.ru
    //выполните такой сценарий:
    //	1) Перейдите в каталог курсов (Курсы - каталог курсов)
    //	2) В поле поиска введите слово "тестирование" и запустите поиск.
    //	3) Найдите на странице курс "Автоматизированное тестирование веб-приложений с использованием Selenium"
    //	(первый в списке)
    //	4) Проверьте, что дата начала "24.01.2026"
   @Test
    void testSpecialist(){
       open("https://specialist.ru");
        // Вариант когда появляется окно cooki - закрываем его. Уточнить, что делать если это окно не появилось,
       // а куки обработаны кодом
       // чтобы найти название кнопки для закрытия окна поп ап с куками, необходимо поставить долгий sleep и в DevTools
       // найти строку по нажатию кнопки закрытия окна с куками
        $x("//button[@id='cookieConsent__ok']").click();
        $x("//a[.='Курсы']").click();  //тег a с таким именем один - проверили в DevTools (Ctrl+F)
        // Откроется выпадающее меню, в нем нужно выбрать 'Каталог курсов'
        sleep(10_000);
        $x("//a[.='Каталог курсов']").click();   // Нажимем на Каталог курсов
        sleep(10_000);

        // Вводим поиск "Тестирование"
        //  $("#CourseName").sendKeys("Тестирование"); // используем CSS селектор
        // Но лучше писать все в одном стиле, например в xpPath
       $x("//input[@id = 'CourseName']").sendKeys("Тестирование");

       //Имитируем нажатие кнопки "Найти" после ввода слова "Тестирование" в строку поиска

        $x("//button[@type='submit']").click();

       String myxPath = "//*[contains(text(),'Автоматизированное тестирование веб-приложений с" +
               " использованием Selenium')]/ancestor::article//dd[contains(@class,'date-start')]";

       // Этот вариант хуже (без contains) потому что в дальнейшем может добавиться другой класс в dd и тогда
       // проверка не сработает, а contain проверяет наличие 1 необходимого класса
       //*[contains(text(),'Автоматизированное тестирование веб-приложений с
       // использованием Selenium')]/ancestor::article//dd[@class='date date-start']

       //Можно указать два класса в проверке
       //*[contains(text(),'Автоматизированное тестирование веб-приложений
       // с использованием Selenium')]/ancestor::article//dd[contains(@class,'date-start') and contains(@class,'date')]

       SelenideElement se =$x(myxPath);  // Ищем наш курс

       //Проверяем дату курса
       se.shouldHave(text("24.01.2026"));  // используем text() - он поглотит все пробелы

   }
}
