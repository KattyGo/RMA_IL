package web.success;

import base.BasePage;
import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.customer.CalendarPage;
import pages.customer.ListTablePage;
import pages.customer.NewSCPage;
import pages.home.DashboardPage;
import pages.login.LoginDealerPage;

import static java.lang.Thread.sleep;

public class ListTicketTest extends BaseTest {

    @Test (testName = "Login", description = "Login for DEALER",priority = 1)
    public void new_customer() throws InterruptedException {
        LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
        DashboardPage dashboardPage = new DashboardPage(getDriver()); // instance of dashboard page
        NewSCPage newSCPage = new NewSCPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        ListTablePage ticketPage = new ListTablePage(getDriver());
        SoftAssert softAssert = new SoftAssert();


        loginPage.type_userName("ishai.levi53345@may.com")
                 .type_password("Gg8fc382")
                 .click_loginButton();
        ticketPage.click_tableLength()
                .selectOptionBy(ListTablePage.selectByOption.VALUE, "-1" ); // open a list of the calls by Value, Text or Index (in dropdown)
        sleep(3000);
    }


}
