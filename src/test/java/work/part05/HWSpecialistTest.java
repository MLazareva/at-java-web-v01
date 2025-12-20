package work.part05;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class HWSpecialistTest {
    // На сайте https://www.specialist.ru/ в модальном окне "Наш сайт использует
    // файлы cookie" нажать "Согласен". Выбрать пункт меню "Форматы обучения",
    // затем "Свободное обучение", затем "Выбрать курс", в поле "Направление" выбрать
    // "Программирование", нажать кнопку "Применить" и убедиться, что на странице
    // есть элемент содержащий текст "Тестирование ПО".
    static void beforeAll() {
        Configuration.pageLoadTimeout= 30_000; // Чтобы успел открыть страницу
        Configuration.pageLoadStrategy = "eager";  // Жадная загрузка - мы не дожидаемся подгрузки всех ресурсов
        // Идем дальше, как только загрузился html
    }
    @Test
    public void test01_HW() {
        open("https://specialist.ru");
        //Закрываем окно с куками
        $x("//button[@id='cookieConsent__ok']").click();
        System.out.println("Закрыли куки 1 ");

        $x("//a[.='Форматы обучения']").click();  //тег a с таким именем один - проверили в DevTools (Ctrl+F)
        System.out.println("Форматы обучения 2 ");

        // Выбрать 'Свободное обучение'
        $x("//a[contains(.,'Свободное обучение')]").click();
        sleep(10_000);
        System.out.println("Свободное обучение 3 ");

        $x("//div[@class='banner-content']/a[contains(.,'Выбрать курс')]").click();
        sleep(10_000);

        System.out.println("Выбрать курс 4 ");

        //Из выпадающего списка выбираем "Программирование"
        $x("//select[@id='Filter_CategoriesDirectionFilter']").selectOptionByValue("ПРГ");
        sleep(10_000);
        System.out.println("Выбрали Программирование 5 ");

        //Закрываем выпадающее меню консультанта
        $x("//jdiv[@class='closeIcon__dHH_W']")
                .shouldHave(visible)
                .shouldHave(clickable)
                .click();

        System.out.println("Закрыли консультации 6 ");

        //Нажимаем "Применить"
        $x("//button[@id='sendBtn']").click();

        System.out.println("Нажали применить 7 ");

        // Проверить, что на странице есть "Тестирование ПО"
        $x("//a[@class='course-link' and @href='/course/tpo']").shouldHave(text("Тестирование ПО"));
        sleep(10_000);

        System.out.println("Нашли текст 8 ");


    }
}
