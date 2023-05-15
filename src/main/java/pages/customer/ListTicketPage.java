package pages.customer;

import base.BasePage;
import enums.Status;
import enums.selectByOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ListTicketPage extends BasePage {

    public ListTicketPage(WebDriver driver) {
        super(driver);
    }

    //*** tbody/tr ---> שורה
    //*** *[@class='staus'] ---> סטטוס
    //*** tbody/tr/td[8] ---> מספר סריאלי

    @FindBy(css = "#tablelength") // number of rows in the table displayed
    private WebElement tableLength;

    //final String lineTicket = "//tbody/tr[1]";

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> lineTicket;


        //*** search the ticket by status ***//
    public void check_status () {
        int count_open = 0;
        int count_close = 0;
        for (int i = 1; i < lineTicket.size(); i++) {
            WebElement el = driver.findElement(By.xpath("//tbody/tr[" + i + "]//*[@class='staus']")); // return open or close service call
            if (el.getText().equals("פתוח")) {
                count_open++;
            } else {
                count_close++;
                }
        }
        log.info("count_open is:" + count_open);
        log.info("count_close is:" + count_close);
    }

        //*** get list of all serial numbers their status is open ***//
    public List<String> getSerialNumberByStatus (Status state) {
        List<String> serial_num = new ArrayList<String>();
        for (int i = 1; i <= lineTicket.size(); i++) {
            WebElement el = driver.findElement(By.xpath("//tbody/tr[" + i + "]//*[@class='staus']"));// return open or close service call
            switch (state) {
                case OPEN:
                    if (el.getText().equals("פתוח")) {
                        serial_num.add(driver.findElement(By.xpath("//tbody/tr[" + i + "]//td[8]")).getText());
                    } break;
                case CLOSE:
                    if (el.getText().equals("סגור")) {
                        serial_num.add(driver.findElement(By.xpath("//tbody/tr[" + i + "]//td[8]")).getText());
                    } break;
            }
        }
        return serial_num;
    }


        //*** click on dropdown of number of rows ***//
    public ListTicketPage click_tableLength() {
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
    //public enum selectByOption {
   //     VALUE, TEXT, INDEX;
   // }
    //public enum Status {
    //    OPEN, CLOSE
    //}
}


