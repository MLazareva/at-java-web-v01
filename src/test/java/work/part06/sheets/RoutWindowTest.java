package work.part06.sheets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter; // Для перевода дня недели на русский


import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class RoutWindowTest {  //Страница - выбор маршрута

    SelenideElement

            cityFrom = $x("//div[@data-test-id='origin-autocomplete']/input[@id='avia_form_origin-input']"),
            cityTo = $x("//div[@data-test-id='destination-autocomplete']/input[@id='avia_form_destination-input']"),
            dataTo   = $x("//button[@data-test-id='start-date-field']"),
            dataBack = $x("//button[@data-test-id='end-date-field']"),
            numberOfPassengers = $x("//button[@data-test-id='passengers-field']"),

            //Кол-во пассажиров
            count_adults   = $x("//div[@data-test-id='number-of-adults']/div[@class='s__EAWmhE9u0MIOj7wG']/div[@data-test-id='passenger-number']"),
            count_children = $x("//div[@data-test-id='number-of-children']/div[@class='s__EAWmhE9u0MIOj7wG']/div[@data-test-id='passenger-number']"),
            count_infants  = $x("//div[@data-test-id='number-of-infants']/div[@class='s__EAWmhE9u0MIOj7wG']/div[@data-test-id='passenger-number']"),


            buttonAdultPlus = $x("//div[@data-test-id='number-of-adults']" +
            "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='increase-button']"),
            buttonAdultMinus = $x("//div[@data-test-id='number-of-adults']" +
                    "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='decrease-button']"),
            buttonChildPlus = $x("//div[@data-test-id='number-of-children']" +
                    "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='increase-button']"),
            buttonChildMinus = $x("//div[@data-test-id='number-of-children']" +
                    "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='decrease-button']"),
            buttonInfantPlus = $x("//div[@data-test-id='number-of-infants']" +
                    "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='increase-button']"),
            buttonInfantMinus = $x("//div[@data-test-id='number-of-infants']" +
                    "//button[@class='s__CLVko2td9BsgMkhH' and @data-test-id='decrease-button']"),

            buttonEconom   = $x("//label[@data-test-id='radio-button'][1]"),
            buttonComfort  = $x("//label[@data-test-id='radio-button'][2]"),
            buttonBusiness = $x("//label[@data-test-id='radio-button'][3]"),
            buttonFirst    = $x("//label[@data-test-id='radio-button'][4]"),
                    findButton = $x("//div[@class='s__q0eubYUq5_sOJDEe']");


    @Step("Поиск рейсов")
    public void searchFlight(String from_param, String to_param, String to_date, String back_date,
                             int adults1, int children1, int infants1, int service_class) {
        // from_param - город вылета
        // to_param - город прилета
        // to_date  - дата вылета
        // back_date - дата прилета
        // adults1 - кол-во взрослых
        // сhildren1 - кол-во детей
        // infants1 - кол-во младенцев
        // service_class - класс обслуживания (1-4->Эконом/Комфорт/Бизнес/Первый класс)


       //----------------- Начало -----Преобразуем даты вылета - прилета  формата 23.12.2025 в вторник, 12 декабря 2025
        // Парсим входящую строку
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date1 = LocalDate.parse(to_date, inputFormatter);  //Дата вылета
        LocalDate date3 = LocalDate.parse(back_date, inputFormatter);  //Дата возврата

        // Форматируем в нужный вид с русской локалью
        // 'EEEE' - полное название дня недели, 'd' - день, 'MMMM' - месяц, 'yyyy' - год
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy");

        String date2 = date1.format(outputFormatter)+" г.";
        String date4 = date3.format(outputFormatter)+" г.";

        System.out.println("Полная дата и день 1: "+ date2.trim());
        System.out.println("Полная дата и день 2: "+ date4.trim());

        // ---------------- Конец--------------------  преобразования даты

        //this.cityFrom.click();    // Заводим Откуда
        this.cityFrom.setValue("");
        this.cityFrom.setValue(from_param);

        this.cityTo.setValue("");
        this.cityTo.setValue(to_param);    // Заводим Куда

        this.dataTo.click();     // Нажимаем на поле даты вылета

        //Выбираем день из календаря
        String dataStr1 = "//button[@aria-label='"+ date2.trim()+"']";
        String dataStr2 = "//button[@aria-label='"+ date4.trim()+"']";

        $x(dataStr1).click();  // Выбираем дату вылета

        this.dataBack.click();     // Нажимаем на поле даты возврата

        $x(dataStr2).click();  // Выбираем дату возврата

        this.numberOfPassengers.click();     // Количество пассажиров

         System.out.println("Кол-во взрослых "+this.count_adults.text());
         System.out.println("Кол-во детей "+this.count_children.text());
         System.out.println("Кол-во младенцев "+this.count_infants.text());

        //Integer i_adult = Integer.parseInt(this.count_adults.text());

        if (adults1 == 1) {  // Если задали 1 взрослого , то ничего не увеличиваем

        } else {
            for (int i = 0; i < adults1; i++) {
                this.buttonAdultPlus.click();   // Увиличиваем число взрослых
            }
        }


            for (int i = 0; i < children1; i++) {
                this.buttonChildPlus.click();   // Увиличиваем число детей
            }

            for (int i = 0; i < infants1; i++) {
                this.buttonInfantPlus.click();  // Уменьшаем число младенцев
            }

        System.out.println("Кол-во взрослых "+this.count_adults.text());
        System.out.println("Кол-во детей "+this.count_children.text());
        System.out.println("Кол-во младенцев "+this.count_infants.text());

          // Выбираем класс обслуживания
        switch(service_class) {
            case 1 -> this.buttonEconom.click();    //Радио-кнопка  //Радио-кнопка
            case 2 -> this.buttonComfort.click();    //Радио-кнопка
            case 3 -> this.buttonBusiness.click();  //Радио-кнопка
            case 4 -> this.buttonFirst.click();     //Радио-кнопка
            default-> this.buttonEconom.click();   //Радио-кнопка
                  }

           /* sleep(3_000);

        this.cityFrom.sendKeys("");
        this.cityFrom.sendKeys(from_param);

        this.cityTo.clear();
        this.cityTo.sendKeys("");
        this.cityTo.sendKeys(to_param);*/

            this.findButton.click();  // Нажать кнопку Найти билеты
        sleep(30000);
    } //Test

} //class
