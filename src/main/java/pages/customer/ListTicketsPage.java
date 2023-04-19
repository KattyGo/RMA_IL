package pages.customer;

import base.BasePage;
import enums.SelectByOption;
import enums.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ListTicketsPage extends BasePage {
    public ListTicketsPage(WebDriver driver) {
        super(driver);
    }


     ////tbody/tr[1]                               ----> שורה
    ////tbody/tr[1]//*[@class='staus']    ----> סטאטוס
    ////tbody/tr[1]//td[8]                ---> מספר מכשיר


//    //======================================================================  =====================================================
//    final By username1 = By.cssSelector("[placeholder='Username']");
//    public void type_userName1(String text){
//        type(driver.findElement(username1),text);
//    }
////======================================================================  =====================================================
//



    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> lineTicket;
    @FindBy(css = "#tablelength")
    private WebElement tablelength ;



    public  void check_status(){
        int count_open = 0;
        int count_close = 0;
        for (int i =1; i<lineTicket.size()+1; i++) {
            WebElement el = driver.findElement(By.xpath("//tbody/tr[" + i + "]//*[@class='staus']"));
            if (el.getText().equals("פתוח")){
                count_open++;
            }else {
                count_close++;
            }

        }
    log.info("count_open is :" +count_open);
    log.info("count_close is :" +count_close);

    }

    public  List<String> getSerialNumbersByStatus(Status state){
        List<String> serial_num = new ArrayList<String>();
        for (int i =1; i<=lineTicket.size(); i++) {
            WebElement el = driver.findElement(By.xpath("//tbody/tr[" + i + "]//*[@class='staus']"));  // open or close
            switch (state){
                case OPEN:
                    if (el.getText().equals("פתוח")){
                        serial_num.add(driver.findElement(By.xpath("//tbody/tr[" + i + "]//td[8]")).getText());
                    }
                    break;
                case CLOSE:
                    if (el.getText().equals("סגור")){
                        serial_num.add(driver.findElement(By.xpath("//tbody/tr[" + i + "]//td[8]")).getText());
                    }
                    break;
            }

        }
        return serial_num;
    }




    public ListTicketsPage click_tablelength(){
        log.info("click tablelength");
        click(tablelength);
        return this;
    }

    public void selectOptionBy(SelectByOption byOption, String value) {
        Select select = new Select(tablelength);
        switch (byOption) {
            case VALUE:
                select.selectByValue(value);
                break;
            case TEXT:
                select.selectByVisibleText(value);
                break;
            case INDEX:
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                log.info("Enter option select by");
        }
    }
}
