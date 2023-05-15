package web.success;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.customer.NewSCPage;
import pages.login.LoginDealerPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CopyFileTest extends BaseTest {

    @Test (testName = "Login", description = "Login for DEALER",priority = 1)
    public void new_customer() throws InterruptedException {
        LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
        NewSCPage newSCPage = new NewSCPage(getDriver());
        loginPage.type_userName("ishai.levi53345@may.com")
                 .type_password("Gg8fc382")
                 .click_loginButton();
        newSCPage.click_excel();
        Thread.sleep(3000);
        Assert.assertTrue(attachFileToAllureReport("target/allure-results/Maytronics Warranty Calls.xlsx"));
    }



    public  boolean attachFileToAllureReport(String filePath) {
        File file = new File(filePath);
        if(file.exists()){
        try {
            byte[] content = Files.readAllBytes(file.toPath());
            Allure.getLifecycle().addAttachment("file Maytronics", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xlsx", content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }else {
            log.error("File not found: "+ filePath);
            return false;
        }
    }
}
