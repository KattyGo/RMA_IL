package web.success;

import base.BaseTest;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.customer.ListTicketsPage;
import pages.login.LoginDealerPage;

import static enums.SelectByOption.TEXT;
import static enums.Status.OPEN;

public class ListTicketTest extends BaseTest {

    @Epic("Login")
    @Test(testName = "login", description = "Login with valid data")
    public void login_test() throws InterruptedException {
        LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
        ListTicketsPage ticketsPage =new ListTicketsPage(getDriver());
        loginPage.type_userName("ishai.levi53345@may.com")
                .type_password("Gg8fc382")
                .click_loginButton();
        ticketsPage.click_tablelength()
                .selectOptionBy(TEXT,"50");
        Thread.sleep(2000);
        log.info("List of open serials number "+ticketsPage.getSerialNumbersByStatus(OPEN));



    }



}


