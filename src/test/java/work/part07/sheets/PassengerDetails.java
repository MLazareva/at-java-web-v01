package work.part07.sheets;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassengerDetails {
    SelenideElement

            dataFlight    = $x("//div[@id='container']"),
            first_name    = $x("//input[@name='passengerFirstName']"),
            last_Name     = $x("//input[@name='passengerLastName']"),
            button_Next   = $x("//input[@type='submit' and  @value='Next']"),
            error_message = $x("//div[@id='flash_alert']");


    public static String makeDateCorrect(String date) {
        //Передаём дату в формате DD.MM.YYYY - выдаем в формате YYYY-MM-DD
        if (Configuration.browser == "chrome" && date != null && date.length() == 10) {
            return date.substring(6, 10) + "-" +
                    date.substring(3, 5) + "-" +
                    date.substring(0, 2);
        }
        return date;
    }

    @Step("Проверяем то, что данные (туда) верно перенесены на следующую страницу(имя-фамилия)")
    public void checkData(String from_p, String to_p,  String date1_p) {

                this.dataFlight.shouldHave(text("oneway trip"));   //Туда (дата-параметр один)
                this.dataFlight.shouldHave(text(from_p));        // Проверяем город вылета
                this.dataFlight.shouldHave(text(to_p));  // Проверяем город прибытия

                String str1 = makeDateCorrect(date1_p);  // переводим 11.12.2025->2025-12-11
                this.dataFlight.shouldHave(text(makeDateCorrect(date1_p)));
                System.out.println("##5 Все данные верны на странице имя-фамилия");

    }//checkData

        @Step("Заполнение полей - имя и фамилия")
        public void enterName(String name1, String name2) {
            this.first_name.type(name1);
            this.last_Name.setValue(name2);  //setValue
            this.button_Next.click();
            System.out.println("##6 Завели данные по пассажиру");
        }//enterName

    @Step("Сообщение о том, что необходимо заполнить фамилию ")
    public void emptyLastName() {
            this.error_message.shouldHave(text("Must provide last name"));
            System.out.println("##7 Необходимо указать имя и фамилию");
    }

    @Step("Проверяем то, что данные (туда-обратно) верно перенесены на следующую страницу(имя-фамилия)")
    public void checkData(String from_p, String to_p,  String date1_p, String date2_p) {

                this.dataFlight.shouldHave(text("return trip"));   //Проверяем тип поездки
                this.dataFlight.shouldHave(text(from_p));        // Проверяем город вылета
                this.dataFlight.shouldHave(text(to_p));  // Проверяем город прибытия


                String str1 = makeDateCorrect(date1_p);  // переводим 11.12.2025->2025-12-11
                this.dataFlight.shouldHave(text(makeDateCorrect(date1_p)));
                String str2 = makeDateCorrect(date2_p);  // переводим 11.12.2025->2025-12-11
                this.dataFlight.shouldHave(text(makeDateCorrect(date2_p)));
                System.out.println("##55 Все данные верны на странице имя-фамилия");



    }//checkData



    }//class main




