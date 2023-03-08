package web.valid;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.customer.NewSCPage;
import pages.home.DashboardPage;
import pages.login.LoginDealerPage;

public class ErrorEmailTest {

    public class NewSCTest extends BaseTest {

        @Ignore
        @Test(testName = "Login", description = "Login for DEALER" ,priority = 2)
        public void new_customer() throws InterruptedException {
            LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
            DashboardPage dashboardPage = new DashboardPage(getDriver()); // instance of dashboard page
            NewSCPage newSCPage = new NewSCPage(getDriver());
            BasePage basePage = new BasePage(getDriver());
            loginPage.type_userName("xxxxxxxxx@may.com")
                    .type_password("Gg8fc382")
                    .click_loginButton();
            Assert.assertEquals(loginPage.get_error_email_text(), "שם משתמש או סיסמה לא נכונים");
            log.warn("Invalid email address");

        }
    }
}
