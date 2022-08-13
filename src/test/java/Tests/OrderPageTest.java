package Tests;
import datafortests.OrderTestData;
import datafortests.QuestionAnswerData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import pages.MainPage;
import pages.OrderPage;


public class OrderPageTest {
    private WebDriver driver;

    @Test
    public void checkHowMuchCostAnswerText  () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        QuestionAnswerData questionAnswerData= new QuestionAnswerData("accordion__heading-0", "accordion__panel-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        MainPage mainPage = new MainPage(driver);
        mainPage.checkAnswerText(questionAnswerData);
        driver.quit();
    }

    @Test
    public void checkWantMoreScootersAnswerText () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        QuestionAnswerData questionAnswerData= new QuestionAnswerData("accordion__heading-1", "accordion__panel-1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        MainPage mainPage = new MainPage(driver);
        mainPage.checkAnswerText(questionAnswerData);
        driver.quit();
    }
    @Test
    public void checkHowCalculatedAnswerText () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        QuestionAnswerData questionAnswerData= new QuestionAnswerData("accordion__heading-2", "accordion__panel-2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        MainPage mainPage = new MainPage(driver);
        mainPage.checkAnswerText(questionAnswerData);
        driver.quit();
    }
    @Test
    public void checkPossibleTodayOrderAnswerText () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        QuestionAnswerData questionAnswerData= new QuestionAnswerData("accordion__heading-3", "accordion__panel-3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        MainPage mainPage = new MainPage(driver);
        mainPage.checkAnswerText(questionAnswerData);
        driver.quit();
    }
    @Test
    public void checkExtendTheOrderAnswerText () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        QuestionAnswerData questionAnswerData= new QuestionAnswerData("accordion__heading-4", "accordion__panel-4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        MainPage mainPage = new MainPage(driver);
        mainPage.checkAnswerText(questionAnswerData);
        driver.quit();
    }

    @Test
    public void checkDoUouBringChargersWithTheScooterAnswerText() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        QuestionAnswerData questionAnswerData= new QuestionAnswerData("accordion__heading-5", "accordion__panel-5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        MainPage mainPage = new MainPage(driver);
        mainPage.checkAnswerText(questionAnswerData);
        driver.quit();
    }
    @Test
    public void checkCanICancelAnOrderAnswerText() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        QuestionAnswerData questionAnswerData= new QuestionAnswerData("accordion__heading-6", "accordion__panel-6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        MainPage mainPage = new MainPage(driver);
        mainPage.checkAnswerText(questionAnswerData);
        driver.quit();
    }
    @Test
    public void checkILiveOutsideTheMCADnswerText() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        QuestionAnswerData questionAnswerData= new QuestionAnswerData("accordion__heading-7", "accordion__panel-7", "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
        MainPage mainPage = new MainPage(driver);
        mainPage.checkAnswerText(questionAnswerData);
        driver.quit();
    }

    @Test
    public void checkOrderViaTopButtonGoogleChromeFirstTestData () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // переходим на страницу тестового приложения
        OrderTestData orderFirstTestData= new OrderTestData("Полина", "Ясакова", "Москва", "Комсомольская", "+798550402222");
        OrderTestData orderSecondTestData= new OrderTestData("24.08.2022", "Мой комментарий для курьера");

        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        /*mainPage.waitForLoadHomePage();*/
        mainPage.clickMakeOrderTopButton();
        OrderPage orderPage = new OrderPage(driver);
        /*orderPage.waitForLoadOrderPage();*/

        orderPage.fillOrderDetailsFirstForm(orderFirstTestData);
        orderPage.clickFurtherButton();
        orderPage.fillOrderDetailsSecondForm(orderSecondTestData);
        orderPage.clickMakeOrderButton();
        orderPage.clickOkButton();
        orderPage.checkOrderIsProcessedText();
        driver.quit();
    }

    @Test
    public void checkOrderViaTopButtonGoogleChromeSecondTestData() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // переходим на страницу тестового приложения
        OrderTestData orderFirstTestData= new OrderTestData("Артем", "Ибрагимов", "Москворечье", "Чистые пруды", "+798550402244");
        OrderTestData orderSecondTestData= new OrderTestData("14.01.2023", "Другой комментарий для курьера");

        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        /*mainPage.waitForLoadHomePage();*/
        mainPage.clickMakeOrderTopButton();
        OrderPage orderPage = new OrderPage(driver);
        /*orderPage.waitForLoadOrderPage();*/

        orderPage.fillOrderDetailsFirstForm(orderFirstTestData);
        orderPage.clickFurtherButton();
        orderPage.fillOrderDetailsSecondForm(orderSecondTestData);
        orderPage.clickMakeOrderButton();
        orderPage.clickOkButton();
        orderPage.checkOrderIsProcessedText();
        driver.quit();
    }
}

