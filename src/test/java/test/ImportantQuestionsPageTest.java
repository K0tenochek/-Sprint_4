package test;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import page.MainSamokatPage;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class ImportantQuestionsPageTest extends BaseUITest {

    private final By chevronLocator;
    private final By contentLocator;
    private final String expectedContent;

    public ImportantQuestionsPageTest(By chevronLocator, By contentLocator, String expectedContent) {
        this.chevronLocator = chevronLocator;
        this.contentLocator = contentLocator;
        this.expectedContent = expectedContent;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {
                        MainSamokatPage.howMuchAndPayChevron,
                        MainSamokatPage.howMuchAndPayContent,
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
                },
                {
                        MainSamokatPage.wishSeveralSamokatChevron,
                        MainSamokatPage.wishSeveralSamokatContent,
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, " +
                                "можете просто сделать несколько заказов — один за другим."
                },
                {
                        MainSamokatPage.howCalculateTimeOfRentChevron,
                        MainSamokatPage.howCalculateTimeOfRentContent,
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                                "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."
                },
                {
                        MainSamokatPage.orderSamokatForTodayChevron,
                        MainSamokatPage.orderSamokatForTodayContent,
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее."
                },
                {
                        MainSamokatPage.extendOrderChevron,
                        MainSamokatPage.extendOrderContent,
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."
                },
                {
                        MainSamokatPage.chargingWithSamokatChevron,
                        MainSamokatPage.samokatWithChargingContent,
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — " +
                                "даже если будете кататься без передышек и во сне. Зарядка не понадобится."
                },

                {
                        MainSamokatPage.cancelOrderChevron,
                        MainSamokatPage.yesCancelContent,
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."
                },

                {
                        MainSamokatPage.deliveryToMkadChevron,
                        MainSamokatPage.everyoneSamokatContent,
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."
                }
        };
    }

    @Test
    public void checkChveronContent() {
        MainSamokatPage objMainPage = new MainSamokatPage(driver);
        objMainPage.scrollAndClick(chevronLocator);
        String content = objMainPage.getText(contentLocator);
        MatcherAssert.assertThat(content, is(expectedContent));
    }
}
