package pages.customer;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ListTablePage extends BasePage {

    public ListTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#tablelength") // number of rows in the table displayed
    private WebElement tableLength;

        //*** click on dropdown of number of rows ***//
    public ListTablePage click_tableLength() {
        click(tableLength);
        log.info("Number of rows is selected");
        return this;
    }

        //*** method of select option how display a list of table ***///
    public void selectOptionBy (selectByOption byOption, String value){
        Select select = new Select(tableLength);
        switch (byOption) {
            case VALUE:
                select.selectByValue(value);
                break;
            case TEXT:
                select.selectByVisibleText(value);
                break;
            case INDEX:
                select.deselectByIndex(Integer.parseInt(value));
                break;
            default:
                log.info("Enter option select by");
        }
    }
    public enum selectByOption {
        VALUE, TEXT, INDEX;
    }
}


