package web.valid;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.customer.NewSCPage;
import pages.home.DashboardPage;
import pages.login.LoginDealerPage;

public class ErrorPassTest {

    public class NewSCTest extends BaseTest {

        @Test(testName = "Login", description = "Login for DEALER",priority = 3)
        public void new_customer() throws InterruptedException {
            LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
            DashboardPage dashboardPage = new DashboardPage(getDriver()); // instance of dashboard page
            NewSCPage newSCPage = new NewSCPage(getDriver());
            loginPage.type_userName("ishai.levi53345@may.com")
                    .type_password("xxxxxxxx")
                    .click_loginButton();
            Assert.assertEquals(loginPage.get_error_email_text(), "שם משתמש או סיסמה לא נכונים");
            log.warn("Invalid email address");

        }
    }
}
