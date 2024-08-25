package test;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import page.AboutRentSamokatFormPage;
import page.ConfirmationOrderPopupPage;
import page.ForWhoSamokatPage;
import page.MainSamokatPage;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class OrderFormTextPageTest extends BaseUITest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String whenBringSamokat;
    private final String rentalPeriod;
    private final String comment;
    private final By orderButtonLocator;
    private final boolean chooseBlack;
    private final boolean chooseGrey;

    public OrderFormTextPageTest(By orderButtonLocator, String name, String surname, String address, String metroStation,
                                 String phone, String whenBringSamokat, String rentalPeriod, String comment,
                                 boolean chooseBlack, boolean chooseGrey) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.whenBringSamokat = whenBringSamokat;
        this.rentalPeriod = rentalPeriod;
        this.comment = comment;
        this.orderButtonLocator = orderButtonLocator;
        this.chooseBlack = chooseBlack;
        this.chooseGrey = chooseGrey;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {MainSamokatPage.buttonOrderTopPage, "Татьяна", "Филиппова", "Санкт-Петербург", "Черкизовская",
                        "99999999999", "15.08.2024", "сутки",
                        "Побыстрее пожалуйста!:)", true, false},
                {MainSamokatPage.buttonOrderBottomPage, "Георгина", "Стоянова", "Москва", "Красносельская",
                        "55555555555", "23.08.2024", "четверо суток",
                        "Жду с нетерпением", true, true},
        };
    }

    @Test
    public void submitOrderSamokatForm() {
        MainSamokatPage objMainPage = new MainSamokatPage(driver);
        ForWhoSamokatPage objWhoSamokatPage = new ForWhoSamokatPage(driver);
        objMainPage.scrollAndClick(orderButtonLocator);
        objWhoSamokatPage.waitNameIsLoaded();
        objWhoSamokatPage.setName(name);
        objWhoSamokatPage.setSurname(surname);
        objWhoSamokatPage.setAddress(address);
        objWhoSamokatPage.setMetroStation(metroStation);
        objWhoSamokatPage.setPhone(phone);
        objWhoSamokatPage.clickNext();

        AboutRentSamokatFormPage aboutRentPage = new AboutRentSamokatFormPage(driver);
        aboutRentPage.setWhenBringSamokat(whenBringSamokat);
        aboutRentPage.setRentalPeriod(rentalPeriod);
        if (chooseBlack) {
            aboutRentPage.chooseBlack();
        }
        if (chooseGrey) {
            aboutRentPage.chooseGrey();
        }
        aboutRentPage.setComment(comment);
        aboutRentPage.clickOrder();

        ConfirmationOrderPopupPage confirmationOrderPopupPage = new ConfirmationOrderPopupPage(driver);
        confirmationOrderPopupPage.waitPageIsLoaded();
        confirmationOrderPopupPage.clickYes();
        String oderStatus = confirmationOrderPopupPage.getOrderStatus();
        MatcherAssert.assertThat(oderStatus, containsString("Заказ оформлен"));
    }
}
