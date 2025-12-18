package work.part04;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class NewDropDownTest {
    @Test
    void test01_DropDown() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/form-fields/");

        sleep(2_000);
        $x("//select[@id='automation']").selectOption(1);
        // либо CSS $("#automation").selectOption(1);
        sleep(2_000);
        $x("//select[@id='automation']").selectOption(0);
        // либо CSS $("#automation").selectOption(0);
        sleep(2_000);
        $x("//select[@id='automation']").selectOption("Undecided");
        // либо CSS $("#automation").selectOption("Undecided");
        sleep(2_000);

        //ищем не по тегу option-текст, а по атрибуту value (!)
        $x("//select[@id='automation']").selectOptionByValue("no");
        // либо CSS $("#automation").selectOption("no");
        sleep(2_000);

        //Возвращаемся наверх сраницы
        $x("//a[.='Home']");

    }
}
