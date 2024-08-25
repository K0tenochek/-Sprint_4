package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForWhoSamokatPage {
    // локатор на поле "Имя"
    private final By inputName = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // локатор на поле "Фамилия"
    private final By inputSurname = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // локатор на поле "Адрес: куда привезти заказ"
    private final By inputAddress = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // локатор на поле "Станция метро"
    private final By inputMetroStation = By.xpath("//input[@class='select-search__input']");
    // локатор на опцию "Станции метро" (останется только одна в списке, так как мы введем название в input)
    private final By optionMetroStation = By.className("select-search__option");
    // локатор на поле "Телефон"
    private final By inputPhone = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // локатор на кнопку "Далее"
    private final By inputNext = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private final WebDriver driver;

    public ForWhoSamokatPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void setMetroStation(String station) {
        driver.findElement(inputMetroStation).sendKeys(station);
        driver.findElement(optionMetroStation).click();
    }

    public void setPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
    }

    public void clickNext() {
        driver.findElement(inputNext).click();
    }

    public void waitNameIsLoaded() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(inputName)
        );
    }
}
