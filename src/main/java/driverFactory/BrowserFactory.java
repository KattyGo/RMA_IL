package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;


public class BrowserFactory {

    protected String browserName;
    public static WebDriver driver;

    public BrowserFactory (String browserName) {
        this.browserName = browserName;
    } // constructor

    public WebDriver createDriver(){

        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        switch (browserName) {

            case "chrome":
                WebDriverManager.chromedriver().setup(); // create chrome driver
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().window().maximize();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup(); // create firefox driver
                firefoxOptions.addPreference ("dom.webnotifications.enabled", false);
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().window().maximize();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup(); // create edge driver
                driver = new EdgeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().window().maximize();
                break;

        }
        return driver;
    }
}
