package work.part03;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AxesPizza {
    //написать автотест, который добавит пиццы "Маргарита" и "Четыре сыра" в корзину, не пользуясь атрибутом data-id
    // т.е. нажать кнопку Добавить, не используя атриьут кнопки
    // Надо подняться на родительский элемент Маргарита и спуститься на дочерний элемент Добавить

    @Test
    public void testxPathAddPizza() {
        open("https://slqamsk.github.io/cases/pizza/v08/");
        // 1. Находим на странице искомы элемент Маргарита (левый квадратик со стрелочкой)
        // Создаем переменную
        // Отлаживать можем в DevTools в строке ^F  :   //h3[.='Маргарита']
        SelenideElement se1 =$x("//h3[.='Маргарита']");  // Испоьзовали CSS-селектор
        // Убедимся, что это h3 (имя тега), еще имя и класс
        System.out.println("Элемент с названием пиццы. Тег:" + se1.getTagName() + ", текст: "+ se1.text());
        //Поднимаемсся теперь к родителю элемента se1 - div class card (! единственный элемент)
        SelenideElement se2 = $x("//h3[.='Маргарита']/..");
        // Проверим какие тег, имя и класс
        System.out.println("Его родитель. Тег:" + se2.getTagName() + ", текст: "+ se2.text());
        SelenideElement se3 = $x("//h3[.='Маргарита']/../button");
        // Проверим какие тег, имя и класс
        System.out.println("Кнопка. Тег:" + se3.getTagName() + ", текст: "+ se3.text());
    }
}
