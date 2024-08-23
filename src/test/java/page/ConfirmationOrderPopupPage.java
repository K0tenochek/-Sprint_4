package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationOrderPopupPage {
    private final WebDriver driver;
    private final By yesButton = By.xpath("//button[text() = 'Да']");
    private final By noButton = By.xpath("//button[text() = 'Нет']");
    private final By textOrderStatus = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    public ConfirmationOrderPopupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPageIsLoaded() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(yesButton));
    }

    public void clickYes() {
        driver.findElement(yesButton).click();
    }

    public void clickNo() {
        driver.findElement(yesButton).click();
    }

    public String getOrderStatus() {
        return driver.findElement(textOrderStatus).getText();
    }
}
