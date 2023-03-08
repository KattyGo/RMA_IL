package web.valid;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.customer.NewSCPage;
import pages.home.DashboardPage;
import pages.login.LoginDealerPage;

import static java.lang.Thread.sleep;

public class ServiceCallExistsTest {

    public class NewSCTest extends BaseTest {

        @Test(testName = "Login", description = "Login for DEALER",priority = 0)
        public void new_customer() throws InterruptedException {
            LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
            DashboardPage dashboardPage = new DashboardPage(getDriver()); // instance of dashboard page
            NewSCPage newSCPage = new NewSCPage(getDriver());
            BasePage basePage = new BasePage(getDriver());
            loginPage.type_userName("ishai.levi53345@may.com")
                    .type_password("Gg8fc382")
                    .click_loginButton();
            dashboardPage.click_newServiceCall();
            newSCPage.type_SerialNumber("Test111111");
            Assert.assertEquals(newSCPage.cant_continue_creating(), "לא ניתן להמשיך תהליך");
            dashboardPage.back_listSC();
            log.warn("Service call with this device number already exists");
            sleep(3000);
        }
    }
}