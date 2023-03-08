package web.success;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.customer.NewSCPage;
import pages.home.DashboardPage;
import pages.login.LoginDealerPage;

import static java.lang.Thread.sleep;

public class NewSCTest extends BaseTest {

    @Test (testName = "Login", description = "Login for DEALER",priority = 1)
    public void new_customer() throws InterruptedException {
        LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
        DashboardPage dashboardPage = new DashboardPage(getDriver()); // instance of dashboard page
        NewSCPage newSCPage = new NewSCPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        loginPage.type_userName("ishai.levi53345@may.com")
                 .type_password("Gg8fc382")
                 .click_loginButton();
        dashboardPage.click_newServiceCall();
        newSCPage.where_SerialNumber();
        basePage.sleep(3000);
        newSCPage.close_PopupWhere()
                .start_ServiceCall()
                .type_emptySN()
                .type_errorSN("Test11")
                .type_NotExists("Test123456")
                .click_ok() // close the popup
                .type_SerialNumber("Test111111")
                .type_firstName("Katty")
                .type_lastName("Golder")
                .type_phoneNumber("123456789")
                .type_branchName("filial#123")
                .select_shipMode();



        sleep(300);

    }

}
