package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRentSamokatFormPage {
    // локатор на поле "Когда привезти самокат"
    private final By inputWhenBringSamokat = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // локатор выбранного дня в календаре
    private final By selectedDateInCalendar = By.className("react-datepicker__day--selected");
    // локатор на дропдаун поле "Срок аренды"
    private final By inputRentalPeriod = By.xpath("//div[@class='Dropdown-control']");
    // локатор на чекбокс "Черный" в блоке "Цвет Самоката"
    private final By colorSamokatCheckboxBlack = By.id("black");
    // локатор на чекбокс "Серый" в блоке "Цвет Самоката"
    private final By colorSamokatCheckboxGrey = By.id("grey");
    // локатор на поле "Комментарий для курьера"
    private final By inputSamokatForCourier = By.xpath("//input[@placeholder='Комментарий для курьера']");
    // локатор на кнопку "Назад"
    private final By backButton = By.className("Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i");
    // локатор на кнопку "Заказать"
    private final By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");

    private final WebDriver driver;

    public AboutRentSamokatFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setWhenBringSamokat(String whenBring) {
        driver.findElement(inputWhenBringSamokat).sendKeys(whenBring);
        driver.findElement(selectedDateInCalendar).click();
    }

    public void setRentalPeriod(String period) {
        driver.findElement(inputRentalPeriod).click();
        By optionSelector = By.xpath(String.format("//div[@class='Dropdown-option'] [text()='%s']", period));
        driver.findElement(optionSelector).click();
    }

    public void chooseBlack() {
        driver.findElement(colorSamokatCheckboxBlack).click();
    }

    public void chooseGrey() {
        driver.findElement(colorSamokatCheckboxGrey).click();
    }

    public void setComment(String comment) {
        driver.findElement(inputSamokatForCourier).sendKeys(comment);
    }

    public void clickOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderButton));
        WebElement element = driver.findElement(orderButton);
        element.click();
    }

    public void clickBack() {
        driver.findElement(backButton).click();
    }
}
