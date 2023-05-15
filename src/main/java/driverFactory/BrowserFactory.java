package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


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
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                //******  set downloading files  ******//
                //========================================
                Map<String, Object> prefs =new HashMap<>();
                String dir = String.valueOf(Paths.get(System.getProperty("user.dir"),"src/main/resources"));
                prefs.put("download.default_directory",dir);
                chromeOptions.setExperimentalOption("prefs",prefs);
                //========================================
                chromeOptions.addArguments("--disable-notifications");
                WebDriverManager.chromedriver().setup(); // create chrome driver
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
