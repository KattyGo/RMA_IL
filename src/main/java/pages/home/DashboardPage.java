package pages.home;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.customer.NewSCPage;

public class DashboardPage extends BasePage {

    @FindBy(css = "h1#mainTit")
    private WebElement title;
    @FindBy(css = "#toggeleAdSearch>h5")
    private WebElement title_search;

    @FindBy (css = "[id=mainTit]") // header "קריאות שירות" of Dashboard page
    private WebElement back_login;

    @FindBy (css = ".logoutLi") // "התנתקות"  button
    private WebElement disconnect_button;

    @FindBy(css = "[id=newWarrantyButton]") // create a new Service Call
    private WebElement new_sc;

    @FindBy(css = ".breadcrumb a:nth-child(1)") // back to a Dashboard page
    private WebElement back_home;

    @FindBy(css = "[id=status]") // "סטטוס קריאה"
    private WebElement status_sc;

    @FindBy(css = "[.status_search option:nth-child(1)]") // "הכל" All service calls
    private WebElement all_sc;

    @FindBy(css = "[.status_search option:nth-child(2)]") // Open service calls "פתוח"
    private WebElement open_sc;

    @FindBy(css = "[.status_search option:nth-child(3)]") // Close service calls "סגור"
    private WebElement close_sc;

    @FindBy(css = "[id=searchBtn]") // search button "חיפוש"
    private WebElement search_button;

    @FindBy(css = "[id=clearBtn]") // clear button "נקה"
    private WebElement clear_button;

    @FindBy(css = ".paginate_button.next") // pagination button "הבא"
    private WebElement next_button;

        //*** click on "התנתקות" button ***//
    public NewSCPage click_disconnect () {
        wait.until(ExpectedConditions.visibilityOf(new_sc));
        click(disconnect_button);
        log.info("Service call with this device number already exists");
        return new NewSCPage(driver);
    }


    public NewSCPage click_newServiceCall () {
        wait.until(ExpectedConditions.visibilityOf(new_sc));
        click(new_sc);
        log.info("User moved next page New Service Call");
        return new NewSCPage(driver);
    }

    public DashboardPage back_loginPage () {
        wait.until(ExpectedConditions.visibilityOf(back_home));
        click(disconnect_button);
        log.info("Back to Login page");
        return this;
    }

    public DashboardPage back_listSC () {
        click(back_home);
        log.info("Back to Login page");
        return this;
    }

    //*** open dropdown "סטטוס קריאה"   ***//
    public DashboardPage click_status () {
        click(status_sc);
        log.info("Dropdown of statuses is open");
        return this;
    }

    public DashboardPage select_status () {
        click(open_sc);
        log.info("Open services calls option is selected");
        return this;
    }

    //*** click on "חיפוש" button ***//
    public DashboardPage click_search () {
        click(search_button);
        log.info("Search is done");
        return this;
    }

    //***  click on "נקה" button ***//
    public DashboardPage click_clear () {
        click(clear_button);
        log.info("Clear of search is done");
        return this;
    }


   public String getText_title(){
        log.info(" get text of page title");
        return getText(title);
   }
   public String getText_title_search(){
        log.info(" get text of page title search");
        return getText(title_search);
   }



    public DashboardPage (WebDriver driver) {super(driver);}

    //public String is_displayTab() {return getText(next_tab);}

    //public void scroll_pattern(){scrollToElement(scroll_pattern);}


}
