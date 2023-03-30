package pages.customer;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class Calendar extends BasePage {


    public Calendar(WebDriver driver) {
        super(driver);

    }

    private Map<Integer, String> daySelectors = new HashMap<>();
    private Map<Integer, String> weekSelectors = new HashMap<>();

    public String createCssDate(int day, int week) {
        daySelectors.put(1, "day:nth-child(1)");
        daySelectors.put(2, "day:nth-child(2)");
        daySelectors.put(3, "day:nth-child(3)");
        daySelectors.put(4, "day:nth-child(4)");
        daySelectors.put(5, "day:nth-child(5)");
        daySelectors.put(6, "day:nth-child(6)");
        daySelectors.put(7, "day:nth-child(7)");

        weekSelectors.put(1, "tr:nth-child(1)");
        weekSelectors.put(2, "tr:nth-child(2)");
        weekSelectors.put(3, "tr:nth-child(3)");
        weekSelectors.put(4, "tr:nth-child(4)");

        String daySelector = daySelectors.get(day);
        String weekSelector = weekSelectors.get(week);
        return weekSelector + " > ." + daySelector;
    }

    public void chooseDate(int day, int week) {
        String cssSelector = createCssDate(day, week);
        WebElement blabla = driver.findElement(By.id("fromdate"));
        click(blabla);
        log.info("==================================== "+cssSelector+" ==========================");
        WebElement dateElement = driver.findElement(By.cssSelector(cssSelector));
        dateElement.click();
    }

}
