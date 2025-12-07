package work.part01;

import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.FileNotDownloadedError;
import com.codeborne.selenide.files.FileFilter;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class test_work01 {
    @Test
    void test001() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "800x400";


        open("http://92.51.36.108:7777/sl.qa");
        sleep(10000);
        SelenideElement a = $("body");
        a.shouldHave(text("Учебные приложения"));
        }
       // $("body").shouldHave(text("Учебные приложения"));

    @Test
    void test002() {
        open("http://92.51.36.108:7777/sl.qa");
        //sleep(10000);
        $("body").shouldHave(text("Учебные приложения"));
    }
}
