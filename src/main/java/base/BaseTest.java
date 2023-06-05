package base;

import driverFactory.BrowserFactory;
import listeners.AllureStepListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.io.IOException;

import static Utils.readFromFiles.Settings.readFromProp;


@Listeners(AllureStepListener.class)
public abstract class BaseTest {

    public static WebDriver driver;
    public static final String  BROWSER_NAME =  readFromProp("browserName");
    public static final String  URL =  readFromProp("url");

    public static final String VERSION = readFromProp("version_browser");
    public static ThreadLocal <WebDriver> tdriver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }
    public Logger log = LogManager.getRootLogger();


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException, ParseException {
        log.info("create browser: " + BROWSER_NAME+":"+ VERSION);
        BrowserFactory browserFactory = new BrowserFactory(BROWSER_NAME);
        tdriver.set(browserFactory.createDriver());
        getDriver().get(URL);

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
