package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainSamokatPage {
    // локатор на шеврон "Сколько это стоит? И как оплатить?"
    public static By howMuchAndPayChevron = By.id("accordion__heading-0");

    // локатор на контент "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
    public static By howMuchAndPayContent = By.xpath("//div[@id='accordion__panel-0']/p");

    // локатор на шеврон "Хочу сразу несколько самокатов! Так можно?"
    public static By wishSeveralSamokatChevron = By.id("accordion__heading-1");

    // локатор на контент "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями,
    // можете просто сделать несколько заказов — один за другим."
    public static By wishSeveralSamokatContent = By.xpath("//div[@id='accordion__panel-1']/p");

    // локатор на шеврон "Как рассчитывается время аренды?"
    public static By howCalculateTimeOfRentChevron = By.id("accordion__heading-2");

    // локатор на контент "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня.
    // Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру.
    // Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."
    public static By howCalculateTimeOfRentContent = By.xpath("//div[@id='accordion__panel-2']/p");

    // локатор на шеврон "Можно ли заказать самокат прямо на сегодня?"
    public static By orderSamokatForTodayChevron = By.id("accordion__heading-3");

    // локатор на контент "Только начиная с завтрашнего дня. Но скоро станем расторопнее."
    public static By orderSamokatForTodayContent = By.xpath("//div[@id='accordion__panel-3']/p");

    // локатор на шеврон "Можно ли продлить заказ или вернуть самокат раньше?"
    public static By extendOrderChevron = By.id("accordion__heading-4");

    // локатор на контент "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."
    public static By extendOrderContent = By.xpath("//div[@id='accordion__panel-4']/p");

    // локатор на шеврон "Вы привозите зарядку вместе с самокатом?"
    public static By chargingWithSamokatChevron = By.id("accordion__heading-5");
    // локатор на контент "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если
    // будете кататься без передышек и во сне. Зарядка не понадобится."
    public static By samokatWithChargingContent = By.xpath("//div[@id='accordion__panel-5']/p");

    // локатор на шеврон "Можно ли отменить заказ?"
    public static By cancelOrderChevron = By.id("accordion__heading-6");

    // локатор на контент "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."
    public static By yesCancelContent = By.xpath("//div[@id='accordion__panel-6']/p");

    // локатор на шеврон "Я жизу за МКАДом, привезёте?"
    public static By deliveryToMkadChevron = By.id("accordion__heading-7");

    // локатор на контент "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    public static By everyoneSamokatContent = By.xpath("//div[@id='accordion__panel-7']/p");

    // локатор на кнопку "Заказать" вверху страницы
    public static By buttonOrderTopPage = By.xpath("//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    // локатор на кнопку "Заказать" внизу страницы
    public static By buttonOrderBottomPage = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

    // локатор на кнопку "Да все привыкли"
    public static By cookieAcceptButton = By.id("rcc-confirm-button");

    private final WebDriver driver;

    public MainSamokatPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollAndClick(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 3).until(
                ExpectedConditions.elementToBeClickable(locator)
        );
        element.click();
    }

    public String getText(By locator) {
        new WebDriverWait(driver, 3).until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        return driver.findElement(locator).getText();
    }
}

