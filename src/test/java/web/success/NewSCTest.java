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

public class NewSCTest extends BaseTest {

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

        //================//==============
       //================//==============


        dashboardPage.click_newServiceCall();
        newSCPage.where_SerialNumber();
        basePage.sleep(1500);
        newSCPage.close_PopupWhere()
                .start_ServiceCall()
               // .type_emptySN()
                //.type_errorSN("Test11")
               // .type_NotExists("Test123456")
               // .click_ok() // close the popup
                .type_SerialNumber("Test111111")
                .type_firstName("Katty")
                .type_lastName("Golder")
                .type_phoneNumber("123456789")
                .type_branchName("filial#123")
                .select_shipMode()
                .select_descFault()
                .type_detailsFault("robot not working")
                .termCondition_checkBox();



        WebElement checkbox = getDriver().findElement(By.cssSelector("[value= 'כבל שחור בספ\"כ']"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());


//                for (int i=0; i < newSCPage.eq().size(); i++){
//                    newSCPage.select_equipment(newSCPage.eq().get(i));
//                }
//                for(String str :newSCPage.eq()){
//                    newSCPage.select_equipment(str);
//                }
//                  for (int i=0; i < newSCPage.getList_checkbox().size(); i++){      // 10 elements -> 0.click -> 1.click
//                      newSCPage.getList_checkbox().get(i).click();
//                }
//
//                  for(String str :newSCPage.eq()){
//                      softAssert.assertTrue(newSCPage.chekIsSelect_equipment(str));
//                }
//                softAssert.assertAll();
//                newSCPage.termCondition_checkBox();
                //.click_submit();




        sleep(300);



    }


}
