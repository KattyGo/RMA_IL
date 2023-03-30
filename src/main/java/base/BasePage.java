package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class BasePage extends BaseTest {

    public WebDriver driver;
    public Logger log = LogManager.getRootLogger();
    protected WebDriverWait wait;
    protected Actions action;
    protected JavascriptExecutor jsExecutor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    protected void js_click(WebElement elem) {
        if (elem == null) {
            log.warn("element is Null");
        }
        for (int i = 0; i < 2; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(elem));
                jsExecutor.executeScript("arguments[0].click();", elem);
                sleep(300);
            } catch (Exception e) {
                log.warn("js_click is FAILED: " + e.getMessage());
                }
            log.error("js_click RETRY: " + i + "___");
        }
    }

    protected void a_click(WebElement elem) {
        System.out.println("click to element: "+ elem);
        if(elem==null) {
            log.warn("element is Null");
        }
        for (int i = 0; i < 2; i++) {
            try {
                action.moveToElement(elem).click().perform();
                sleep(300);
            }
            catch (Exception e) {
                log.warn("Actions click Failed: "+e.getMessage());
            }
            log.error("Actions click Retry: "+i+"-----");
        }
    }

    protected void click(WebElement elem) {
        System.out.println("click to element: "+ elem);
        if(elem==null) {
            log.warn("element is Null");
        }
        for (int i = 0; i < 2; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOf(elem));
                elem.click();
                sleep(200);
                break;
            } catch (Exception e) {
                    log.warn("click Failed: " + e.getMessage());
                }
                log.error("click Retry: " + i + "-----");
            }
        }

    protected void double_click(WebElement elem) {
        log.info("click to element: "+ elem);
        if(elem==null) {
            log.warn("element is Null");
        }
        for (int i = 0; i < 2; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOf(elem));
                elem.click();
                sleep(1000);
                elem.click();
            } catch (Exception e) {
                log.warn("click Failed: " + e.getMessage());
            }
            log.error("click Retry: " + i + "-----");
        }
    }

    protected void type (WebElement elem, String text) {
        if(elem==null) {
            log.warn("element is Null");
        } try {
                wait.until(ExpectedConditions.visibilityOf(elem));
                elem.clear();
                elem.sendKeys(text);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                    }
           } catch (Exception e) {
                log.warn("click Failed: " + e.getMessage());
            }
    }

    protected String getText(WebElement elem) {
        if (elem == null) {
            log.warn("element is Null");
        }
        String text = null;
        int count = 0;
        boolean succeed = false;
        while (count < 2 && !succeed)
            try {
                text = elem.getText();
                succeed = true;
                sleep(200);
            } catch (StaleElementReferenceException e) {
                e.toString();
                log.warn("Trying to recover from a stale element: " + e.getMessage());
                sleep(200);
                count = count + 1;
            }
        return text;
    }

     //*** sleep for 'x' milly seconds ***//
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            log.error("sleep: FAILED {}" + e.getMessage());
            Thread.currentThread().interrupt(); /* this line will keep Thread.interrupted() returns true */
            throw new IllegalStateException("Invalid sleep");
        }
    }

    //*** scroll to the element ***//
    public void scrollToElement(WebElement elem) {
        log.info("Scrolling to the element: " +elem );
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", elem);
    }

    //*** scroll to end of page ***//
    public void scrollEndPage(WebElement elem) {
        log.info("Scrolling to the element: " +elem );
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //*** scroll to the element by ACTION ***//
    protected void scrollAction (WebElement elem) {
        log.info("Scrolling to the element: " +elem);
        action.moveToElement(elem);
        action.perform();
    }

    //*** delete text from field ***//
    protected void removeText (WebElement elem) {
        log.info("Text has been removed: " +elem);
        action.sendKeys(Keys.CONTROL, Keys.chord("a"));
        sleep(100);
        action.sendKeys(Keys.BACK_SPACE);
    }

    protected void randomElement (WebElement elem) {

    }

    //***   get current date time   ***//
    public String currentDate(){
        Calendar calendar = Calendar.getInstance();
        Date currentDateTime = calendar.getTime();
        log.info(currentDateTime);
        String strData = currentDateTime.toString();
        return strData;
    }

    //***   get future date time   ***//
    public void futureDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date futureDateTime = calendar.getTime();
        log.info(futureDateTime);
    }

    //***   get past date time   ***//
    public void pastDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -10);
        Date pastDateTime = calendar.getTime();
        log.info(pastDateTime);
    }


}

