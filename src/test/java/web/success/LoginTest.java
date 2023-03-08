package web.success;

import base.BasePage;
import base.BaseTest;
import io.qameta.allure.Epic;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import  org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.home.DashboardPage;
import pages.login.LoginDealerPage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginTest  extends BaseTest {

    @Epic("Login")
    @Test(testName = "login", description = "Login with valid data", dataProvider = "example")
    public void login_test(String data) throws InterruptedException {
        BasePage basePage = new BasePage(getDriver());
        LoginDealerPage loginPage = new LoginDealerPage(getDriver()); // instance of login page
        DashboardPage dashboardPage = new DashboardPage(getDriver()); // instance of dashboard page
        String inputData[] = data.split(",");
        loginPage.createLogin(inputData[0], inputData[1]);
        log.info(loginPage.get_logo_text());
        loginPage.click_loginButton();
        //basePage.sleep(5000);

    }

    @DataProvider(name = "example")
    public String[] readJson() throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        BufferedReader buff= new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/data.json"), "UTF-8"));
        Object obj=jsonParser.parse(buff);
        JSONObject searchingJeson=(JSONObject) obj;
        JSONArray searchingJesonArray=(JSONArray)searchingJeson.get("Login_id's");
        String arr[]=new String[searchingJesonArray.size()];
        for(int i=0; i<searchingJesonArray.size();i++){
            JSONObject search=(JSONObject)searchingJesonArray.get(i);
            String name=(String)search.get("username");
            String pass=(String)search.get("password");
            arr[i]=name+","+pass;
        }
        return arr;

    }

}


