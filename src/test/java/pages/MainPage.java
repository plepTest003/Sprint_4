package pages;
import datafortests.QuestionAnswerData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// Класс основной страницы
public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // Кнопка «Заказать»
    private final By makeOrderTopButton = By.className("Button_Button__ra12g");
    private final By makeOrderBottomButton = By.className("Button_Button__ra12g Button_UltraBig__UU3Lp");

    public void clickMakeOrderTopButton() {
        driver.findElement(makeOrderTopButton).click();
    }
    private MainPage clickOnQuestion(String buttonId) {
        new WebDriverWait(driver, 3)
            .until(ExpectedConditions.elementToBeClickable(By.id(buttonId)));
        WebElement element = driver.findElement(By.id(buttonId));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return this;
    }
    private MainPage checkText(String textBlock, String expectedText) {
        String answerText = driver.findElement(By.id(textBlock)).getText();
        Assert.assertEquals(expectedText, answerText);
        return this;
    }
    public MainPage checkAnswerText(QuestionAnswerData questionAnswerData) {
        clickOnQuestion(questionAnswerData.buttonId);
        checkText(questionAnswerData.textBlock, questionAnswerData.expectedText);
        return this;
    }

}
