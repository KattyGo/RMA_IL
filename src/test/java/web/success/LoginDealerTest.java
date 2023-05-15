package web.success;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.customer.NewSCPage;
import pages.home.DashboardPage;
import pages.login.LoginDealerPage;

import static java.lang.Thread.sleep;

public class LoginDealerTest extends BaseTest {

    @Test (testName = "Login", description = "Login for DEALER")
    public void new_customer() throws InterruptedException {
        LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
        DashboardPage dashboardPage = new DashboardPage(getDriver()); // instance of dashboard page
        NewSCPage newCustomerPage = new NewSCPage(getDriver());
        loginPage.type_userName("ishai.levi53345@may.com")
                    .type_password("Gg8fc382")
                    .click_loginButton()
                        .click_status()
                        .click_search()
                        .click_clear()
                        ;

        sleep(3000);

    }

}
