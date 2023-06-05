package web.success;

import Utils.readFromFiles.TestData;
import base.BaseTest;
import io.qameta.allure.Epic;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.login.LoginDealerPage;

import java.io.IOException;

public class NewLogin extends BaseTest {


    @Epic("Login")
    @Test(testName = "login", description = "Login with valid data")
    public void login_test() throws IOException, ParseException {
        LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
//        loginPage.createLogin(TestData.loadData().get("username"),TestData.loadData().get("password"));
        loginPage.login(TestData.loadData().get("username"),TestData.loadData().get("password"));

    }
}
