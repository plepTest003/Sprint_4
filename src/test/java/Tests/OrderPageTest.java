import datafortests.OrderTestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import pages.MainPage;
import pages.OrderPage;

public class OrderPageTest {


//    @Before
//    public void startUp() {
//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//    }

    @Test
    public void checkOrderViaTopButton () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // переходим на страницу тестового приложения
        OrderTestData orderTestData= new OrderTestData("Polina", "Ias", "Moscow", "Сокольники", "+700000000");

        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
//        mainPage.waitForLoadHomePage();
        mainPage.clickMakeOrderTopButton();
        OrderPage orderPage = new OrderPage(driver);
//        orderPage.waitForLoadOrderPage();

        orderPage.fillOrderDetailsForm(orderTestData);

    }
    /*@After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }*/
}

