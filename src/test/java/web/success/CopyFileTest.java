package web.success;

import base.BasePage;
import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.customer.CalendarPage;
import pages.customer.NewSCPage;
import pages.home.DashboardPage;
import pages.login.LoginDealerPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import static java.lang.Thread.sleep;

public class CopyFileTest extends BaseTest {

    @Test (testName = "Login", description = "Login for DEALER",priority = 1)
    public void new_customer() throws InterruptedException {
        LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
        NewSCPage newSCPage = new NewSCPage(getDriver());
        loginPage.type_userName("ishai.levi53345@may.com")
                 .type_password("Gg8fc382")
                 .click_loginButton();
        newSCPage.click_excel();
        attachFileToAllureReport("target/allure-results/Maytronics Warranty Calls.xlsx");
    }



    public  void attachFileToAllureReport(String filePath) {
        File file = new File(filePath);
        try {
            byte[] content = Files.readAllBytes(file.toPath());
            Allure.getLifecycle().addAttachment("file Maytronics", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xlsx", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
