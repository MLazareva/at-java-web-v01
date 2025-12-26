package work.part07.sheets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class CardDetails {
    SelenideElement
            dataCard    = $x("//div[@style='margin-left: 3px']/i"),
            cardType    = $x("//input[@name='card_type'])[1]"),

            cardHolder  = $x("//input[@name='holder_name']"),
            cardNumber  = $x("//input[@name='card_number']");



    @Step("Проверяем то, что данные верно перенесены на следующую страницу(данные карточки)")
    public void checkCard(String from_p, String to_p, String flight_p) {
        switch (flight_p) {   //Проверяем тип поездки
            case "1" -> {
                System.out.println("SSSSSSSSS "+this.dataCard.text());
                this.dataCard.shouldHave(text("oneway"));   //Проверяем тип поездки
                this.dataCard.shouldHave(text(from_p));        // Проверяем город вылета
                this.dataCard.shouldHave(text(to_p));  // Проверяем город прибытия

            }
            case "2" -> {   // Сделать Марина
                System.out.println("both side");
                this.dataCard.shouldHave(text("return trip"));
            }
            default -> this.dataCard.shouldHave(text("error with parameters"));
        }
    }//checkData

    @Step("Заполнение полей - данные карточки")
    public void enterDataCard(String type_card, String name1, String name2) {
        switch(type_card){
            case "1" -> this.cardType.click();
            case "2" -> this.cardType.click();
            default -> this.cardType.click();
        }

    }//enterName


}//Class main
