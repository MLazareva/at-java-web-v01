package work.part07.sheets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;



public class CardDetails {
    SelenideElement
            dataCard     = $x("//div[@style='margin-left: 3px']/i"),
            cardType1    = $x("//input[@name='card_type'][1]"),
            cardType2    = $x("//input[@name='card_type'][2]"),
            cardNumber   = $x("//input[@name='card_number']"),
            card_month   = $x("//select[@name='expiry_month']"),
            card_year     = $x("//select[@name='expiry_year']"),
            buttonPayNow  = $x("//input[@type='submit' and @value='Pay now']"),
            getConfirm    = $x("//div[@id='confirmation']"),
            booking_number = $x("//div[@id='confirmation']//span[@id='booking_number']"),
            flights        = $x("//div[@id='confirmation']/div"),
            passengerDetails = $x("//div[@id='confirmation']/p/label");



    @Step("Проверяем то, что данные верно перенесены на следующую страницу(данные карточки)")
    public void checkCard(String from_p, String to_p, String flight_p) {
        switch (flight_p) {   //Проверяем тип поездки
            case "1" -> {
                System.out.println("CARD!!!!!!"+ this.dataCard.text());
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
    public void enterDataCard(String type_card, String card_n, String card_m, String card_y ) {
        switch(type_card){
            case "1" -> this.cardType1.click();
            case "2" -> this.cardType2.click();
            default -> this.cardType1.click();
        }
        this.cardNumber.setValue(card_n);

        this.card_month.selectOptionByValue(card_m);  // Заводим месяц карточки
        this.card_year.selectOptionByValue(card_y);   // Заводим год карточки

        this.buttonPayNow.click();  // Нажимаем [Pay now]

        sleep(3000);


    }//enterName

    @Step("Подтверждение наличия регистрации на рейс")
    public void getConfirmation() {
        this.getConfirm.shouldBe(visible);
        System.out.println("ЕСТЬ РЕГИСТРАЦИЯ");
    }

    @Step("Проверяем то, что данные в Confirmation верны")
    public void checkConfirmData(String from_p, String to_p,  String date1_p, String flight_p, String name1, String name2) {

        this.booking_number.shouldBe(visible); //Проверяем что есть номер бронирования 'Booking number  ####'
        System.out.println("ЕСТЬ НОМЕР РЕГИСТРАЦИИ");

        switch (flight_p) {   //Проверяем тип поездки
            case "1" -> {

                this.flights.shouldHave(text("oneway Trip"));   //Проверяем тип поездки
                System.out.println("ЕСТЬ ТИП РЕЙСА 1");
                String str1 =  PassengerDetails.makeDateCorrect(date1_p); //Преобразуем дату
                this.flights.shouldHave(text(str1.trim())); // Проверяем дату вылета
                System.out.println("ЕСТЬ ДАТА РЕЙСА");
                this.flights.shouldHave(text(from_p));     // Проверяем город вылета
                System.out.println("ЕСТЬ ГОРОД ОТПРАВЛЕНИЯ");
                this.flights.shouldHave(text(to_p));      // Проверяем город прибытия
                System.out.println("ЕСТЬ ГОРОД ПРИБЫТИЯ");

                this.passengerDetails.shouldHave(text(name1+" "+name2)); // Проверяем  имя и фамилию
                System.out.println("ЕСТЬ имя ФАМИЛИЯ3333333"+name1+" "+name2);

            }
            case "2" -> {   // Сделать Марина
              //  System.out.println("both side");
              //  this.dataFlight.shouldHave(text("return trip"));
            }
           // default ->// this.dataFlight.shouldHave(text("error with parameters"));
        }
    }//checkData

}//Class main
