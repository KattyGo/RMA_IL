package web.success;

import base.BaseTest;
import enums.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.customer.ListTicketPage;
import pages.login.LoginDealerPage;

import static enums.SelectByOption.VALUE;
import static java.lang.Thread.sleep;

public class ListTicketTest extends BaseTest {

    @Test (testName = "Login", description = "Login for DEALER",priority = 1)
    public void new_customer() throws InterruptedException {
        LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
        ListTicketPage ticketPage = new ListTicketPage(getDriver());
        loginPage.type_userName("ishai.levi53345@may.com")
                 .type_password("Gg8fc382")
                 .click_loginButton();
        ticketPage.click_tableLength()
                .selectOptionBy(VALUE, "-1" ); // open a list of the calls by Value, Text or Index (in dropdown)
        sleep(3000);
        ticketPage.check_status();
        sleep(2000);
        log.info("list of all serial number in status Open: "+ticketPage.getSerialNumberByStatus(Status.OPEN));

        }


}
