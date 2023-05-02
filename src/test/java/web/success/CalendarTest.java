package web.success;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.customer.CalendarPage;
import pages.customer.NewSCPage;
import pages.home.DashboardPage;
import pages.login.LoginDealerPage;

import static java.lang.Thread.sleep;

public class CalendarTest extends BaseTest {

    @Test (testName = "Login", description = "Login for DEALER",priority = 1)
    public void new_customer() throws InterruptedException {
        LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
        DashboardPage dashboardPage = new DashboardPage(getDriver()); // instance of dashboard page
        NewSCPage newSCPage = new NewSCPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        CalendarPage calendar =new CalendarPage(getDriver());
        SoftAssert softAssert = new SoftAssert();


        loginPage.type_userName("ishai.levi53345@may.com")
                 .type_password("Gg8fc382")
                 .click_loginButton();
        calendar.chooseFromDate(1,2);
        sleep(2000);
        calendar.chooseToDate(5,4);
        sleep(3000);
        dashboardPage.click_search();
        sleep(5000);

    }

}
