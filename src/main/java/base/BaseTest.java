package base;

import driverFactory.BrowserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public abstract class BaseTest {

    public static WebDriver driver;
    public  ThreadLocal <WebDriver> tdriver = new ThreadLocal<>();

    public   WebDriver getDriver() {
        return tdriver.get();
    }
    public Logger log = LogManager.getRootLogger();

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName", "version_br", "url"})

    public void setUp(String browserName, String version_br, String url){
        log.info("create browser: " + browserName);
        BrowserFactory browserFactory = new BrowserFactory(browserName);
        tdriver.set(browserFactory.createDriver());
        getDriver().get(url);

        }

    @AfterMethod(alwaysRun = true)
        public void coverDown(){
            try {
                getDriver().quit();
                }
            catch (Exception e) {
                System.out.println("Close driver");
                }
        }

}
