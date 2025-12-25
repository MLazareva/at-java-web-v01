package work.part07.sheets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class InputLogin {

    SelenideElement
            userName = $x("//input[@id='username']"),
            passWord = $x("//input[@id='password']"),
            checkBox = $x("//input[@id='remember_me']"),
            button_signIn = $x("//input[@name='commit']"),
            errorMessage = $x("//div[@id='flash_alert']"),
            correctLogin = $x("//div[@id='flash_notice']");


    @Step("Регистрация в системе без remember")
    public void loginFunc(String username, String password) {
        this.userName.setValue(username);
        this.passWord.setValue(password);
        this.button_signIn.click();
    }

    @Step("Регистрация в системе c remember")
    public void loginFunc(String username, String password, String ch_p) {
        this.userName.setValue(username);
        this.passWord.setValue(password);
        this.checkBox.click();  // Нажимаем Remember me
        this.button_signIn.click();
    }

    @Step("Неуспешный логин или пароль")
    public void LoginUnsuccessful() {
        this.errorMessage.shouldBe(visible);
        this.errorMessage.shouldHave(text("Invalid email or password"));
    }

    @Step("Успешная регистрация")
    public void LoginSuccessful() {
        this.correctLogin.shouldHave(text("Signed in!"));
    }

}
