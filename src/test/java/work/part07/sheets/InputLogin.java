package work.part07.sheets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class InputLogin {

    SelenideElement
            userName = $x("//input[@id='username']"),
            passWord = $x("//input[@id='password']"),
            checkBox = $x("//input[@id='remember_me']"),
            button_signIn = $x("//input[@name='commit']"),
            errorMessage = $x("");


    @Step("Регистрация в системе без remember")
    public void loginFunc(String username, String password) {
        this.userName.setValue(username);
        this.passWord.setValue(password);
        System.out.println("без remember");
        sleep(5_000);
        this.button_signIn.click();
        sleep(5_000);
    }

    @Step("Регистрация в системе c remember")
    public void loginFunc(String username, String password, String ch_p) {
        this.userName.setValue(username);
        this.passWord.setValue(password);
        System.out.println("c remember");
        this.checkBox.click();  // Нажимаем Remember me
        sleep(5_000);
        this.button_signIn.click();
        sleep(5_000);
    }

}
