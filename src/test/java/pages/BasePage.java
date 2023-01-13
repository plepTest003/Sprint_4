package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    protected WebDriver driver;

    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
    }
}
