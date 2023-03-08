package pages.login;

import base.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.home.DashboardPage;

public class LoginDealerPage extends BasePage {

    public LoginDealerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[id=emailvalue]") // input username field
    private WebElement userName;

    @FindBy(css = "[id=passvalue]") // input password field
    private WebElement password;

    @FindBy(css = "[id=submitloginbtn]") // login button
    private WebElement login_button;

    @FindBy(css = ".ibox-content img") // logo text
    private WebElement logo;

    @FindBy(css = ".text-danger.err") // error email/ password address
    private WebElement error_login;

    public String get_error_email_text (){
        return error_login.getText();
    }

    @Step("Click on Login button")
    @Description("Login button")
    public DashboardPage click_loginButton () {
        click(login_button);
        return new DashboardPage(driver);
    }

    public LoginDealerPage type_userName (String text) {
        log.info("Typing user name "+ text);
        type(userName, text);
        log.info("End typing user name");
        return this;
    }

    public LoginDealerPage type_password (String pass) {
        type(password, pass);
        return this;
    }

    @Step("Type {username} / {pass}.")  // entering credential value
    public DashboardPage createLogin(String username, String pass) {
        type_userName(username);
        type_password(pass);
        return new DashboardPage(driver);
    }

    public String get_logo_text () {
        return getText(logo);
    }

}
