package pages;
import datafortests.OrderTestData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.OperationsException;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class OrderPage extends BasePage {

    // Для поиска одного элемента
    private final By placeholderName = By.xpath(".//input[@placeholder = '* Имя']");
    private final By placeholderSurname = By.xpath(".//input[@placeholder = '* Фамилия']");
    private final By userAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By metroStationList = By.xpath(".//input[@class='select-search__input']");
    private final By metroStationSelection = By.xpath(".//li[@data-index='14']");
    private final By userPhone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private final By inputDataBlock = By.className("react-datepicker__input-container");
    private final By furtherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By backButton = By.xpath(".//[@class=Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i]");
    private final By daySelection = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private final By inputRentalPeriodBlock = By.className("Dropdown-control");
    private final By rentalPeriod = By.xpath(".//div[@placeholder = '* Когда привезти самокат']");
    private final By blackScooterColour = By.className("Checkbox_Input__14A2w");
    private final By orderCommentBlock = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private final By makeOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By okButton = By.xpath(".//button[text()='Да']");
    private final By orderIsProcessedText = By.className("Order_ModalHeader__3FDaJ");


    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    private OrderPage fillName(String userName) {
        driver.findElement(placeholderName).sendKeys(userName);
        return this;
    }

    private OrderPage fillSecondName(String userSurname) {
        driver.findElement(placeholderSurname).sendKeys(userSurname);
        return this;
    }

    private OrderPage fillAddress(String address) {
        driver.findElement(userAddress).sendKeys(address);
        return this;
    }

    private OrderPage fillMetroStation(String metroStation) {
        driver.findElement(metroStationList).click();
        driver.findElement(metroStationSelection).click();
        return this;
    }

    private OrderPage fillPhone(String phoneNumber) {
        driver.findElement(userPhone).sendKeys(phoneNumber);
        return this;
    }

    public void clickFurtherButton() {
        driver.findElement(furtherButton).click();
    }

    private OrderPage fillDay(String date) {
        driver.findElement(inputDataBlock).click();
        driver.findElement(daySelection).sendKeys(date);
        driver.findElement(daySelection).sendKeys(Keys.ENTER);
        return this;
    }

    private OrderPage fillRentalPeriod() {
        driver.findElement(inputRentalPeriodBlock).click();
        driver.findElement(By.xpath("//*[text()='сутки']")).click();
        return this;
    }
    private OrderPage fillScooterColour() {
        driver.findElement(blackScooterColour).click();
        return this;
    }
    private OrderPage fillOrderComment(String orderComment) {
        driver.findElement(orderCommentBlock).click();
        driver.findElement(orderCommentBlock).sendKeys(orderComment);
        return this;
    }

    public void clickMakeOrderButton() {
        driver.findElement(makeOrderButton).click();
    }
    public void clickOkButton() {
        driver.findElement(okButton).click();
    }
    public void checkOrderIsProcessedText() {
        // проверяем на соответствие
        assertTrue(driver.findElement(orderIsProcessedText).getText().contains("Заказ оформлен"));
    }

    public OrderPage fillOrderDetailsFirstForm(OrderTestData order) {
        fillName(order.getUserName());
        fillSecondName(order.getUserSurname());
        fillAddress(order.getAddress());
        fillMetroStation(order.getMetroStation());
        fillPhone(order.getPhoneNumber());
        return this;
    }
    public OrderPage fillOrderDetailsSecondForm(OrderTestData order) {
        fillDay(order.getOrderDate());
        fillRentalPeriod();
        fillScooterColour();
        fillOrderComment(order.getOrderComment());
        return this;
    }

}
