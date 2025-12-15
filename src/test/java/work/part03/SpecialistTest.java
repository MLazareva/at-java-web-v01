package work.part03;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
   }
}
