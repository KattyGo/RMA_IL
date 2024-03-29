package pages.customer;

import base.BasePage;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewSCPage extends BasePage {

    public NewSCPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[id=newWarrantyButton]") // button "Create a new Service Call"
    private WebElement new_sc;

    @FindBy(css = ".breadcrumb .active") // text in main 'קריאת שירות חדשה - הכנס מספר מכשיר'
    private WebElement begin_new_sc;

    @FindBy(css = ".pull-right:nth-child(6)") // text in main 'איפה ניתן למצוא את מספר המכשיר?'
    private WebElement where_sn;

    @FindBy(css = ".vc_custom_heading") // text in popup 'איפו ניתן למצוא את מספר המכשיר?'
    private WebElement header_popup;

    @FindBy(css = ".modal-body button.close") // "x" button in popup
    private WebElement close_popup;

    @FindBy(css = ".srcBtn.startSrc") // start button "החל"
    private WebElement start_button;

    @FindBy(css = ".form-control.startInputSernu") // correct serial number
    private WebElement correct_sn;

    @FindBy(css = "#SERNUM-error") // Notification about incorrect serial number (between 8-12)
    private WebElement incorrect_sn;

    @FindBy(css = ".field-validation-error:nth-child(3)") // notification about required field
    private WebElement require_sn;

    @FindBy(css = ".toast-title") // popup "s/n doesn't exists"
    private WebElement error_SerialNumber;

    @FindBy(css = ".btn.btn-primary.confirmBtn") // OK on error serial number popup
    private WebElement ok_errorSnPopup;

    @FindBy(css = ".row .contactDiv .info-title") // title "פרטי הלקוח"
    private WebElement customDetails;

    @FindBy(css = "[id=FName]") // field "שם פרטי"
    private WebElement fName;

    @FindBy(css = "[id=LName]") // field "שם משפחה"
    private WebElement lName;

    @FindBy(css = "[id=Phone]") // field "טלפון"
    private WebElement phNumber;

    @FindBy(css = "[id=BranchILName]") // field "שם הסניף"
    private WebElement brName;

    @FindBy(css = ".pull-right") // COOKIES - end of page
    private WebElement cookies_SC;

    @FindBy(css = "[id=stepTitle]") // notification - "לא ניתן להמשיך תהליך"
    private WebElement cant_continue;

    @FindBy(css = "[id=shipmode]") // dropdown  "שיטת משלוח"
    private WebElement shipMode;

    @FindBy(css = "[id=faultreason]") // dropdown  "תיאור התקלה"
    private WebElement descFault;

    @FindBy (how = How.XPATH, using = "//option[contains(text(),'כבל לא תקין')]") // option in dropdown "תיאור התקלה"
    static WebElement reasonFault;

    @FindBy(css = "[id=faultDes]") // text field "פירוט התקלה"
    private WebElement detailsFault;

    @FindBy(css = ".accessories.col-md-6.col-sm-6 .checkbox__input .acsDesccheck")   // list of all checkboxes from "ציוד נלווה" field
    private List<WebElement> allElements;

    //@FindBy(how=How.XPATH, using = "//span[contains(text(),'אשר את')]")  // term&conditions checkbox
    @FindBy(css = ".radio__label.ppTerm")
    private WebElement term;

    @FindBy(css = ".btn.btn-default.buttons-excel") // excel button
    private WebElement excel_collect;

    public NewSCPage click_excel(){
        click(excel_collect);
        return this;
    }

    //private WebElement termCheck;


    @FindAll({
            @FindBy(how=How.XPATH, using = "//span[contains(text(),'אשר את')]"),  // term&conditions checkbox
            @FindBy(how=How.CSS, using = ".radio__label.ppTerm")
    })
    private WebElement termCheck;

    @FindBy(css = ".srcBtnRMA")     // button "שלח"
    private WebElement submit;

    //***  button "Create a new Service Call"  ***//
    public NewSCPage createNew_sc() {
        click(new_sc);
        log.info("Starting create a new service call");
        return this;
    }

    //***   text in 'breadcrumb' line   ***//
    public NewSCPage begin_newSC () {
        click(begin_new_sc);
        return this;
    }

    //***   link to popup "where find a serial number"   ***//
    public NewSCPage where_SerialNumber() {
        wait.until(ExpectedConditions.visibilityOf(begin_new_sc));
        click(where_sn);
        return this;
    }

    //***   close the popup "where find a serial number"   ***//
    public NewSCPage close_PopupWhere() {
        wait.until(ExpectedConditions.visibilityOf(header_popup));
        click(close_popup);
        log.info("User close the popup Where");
        return new NewSCPage(driver);
    }

    //***   button "start"   ***//
    public NewSCPage start_ServiceCall() {
        click(start_button);
        log.info("Start to create a new SC");
        sleep(2000);
        return this;
    }

    //***   empty serial number field   ***//
    public NewSCPage type_emptySN() {
        click(start_button);
        sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(require_sn));
        log.warn("Required field - must be filled");
        return this;
    }

    //***   insert correct value in serial number field   ***//
    public NewSCPage type_SerialNumber(String text) {
        wait.until(ExpectedConditions.visibilityOf(correct_sn));
        type(correct_sn, text);
        click(start_button);
        log.info("serial number: " + text);
        return this;
    }

    //***   insert incorrect value in serial number field   ***//
    public NewSCPage type_NotExists (String text) {
        wait.until(ExpectedConditions.visibilityOf(correct_sn));
        type(correct_sn, text);
        click(start_button);
        sleep(2000);
        log.info("serial number: " + text+ "doesn't exists");
        return this;
    }

    //***   insert less 8 chars in serial number field   ***//
    public NewSCPage type_errorSN(String text) {
        type(correct_sn, text);
        click(start_button);
        wait.until(ExpectedConditions.visibilityOf(incorrect_sn));
        log.warn("For serial number: " + text + "Device number must be between 8 and 12 digits");
        sleep(2000);
        //removeText(correct_sn);
        return this;
    }

    //***   close the popup "s/n doesn't exists"   ***//
    public NewSCPage click_ok() {
        wait.until(ExpectedConditions.visibilityOf(ok_errorSnPopup));
        click(ok_errorSnPopup);
        log.info("popup closed");
        sleep(1000);
        return this;
    }

    //***   user cannot continue creating newSC   ***//
    public String cant_continue_creating (){
        return cant_continue.getText();
    }

    //***   fill first name field   ***//
    public NewSCPage type_firstName(String text) {
        wait.until(ExpectedConditions.visibilityOf(customDetails));
        type(fName, text);
        log.info("first name: " + fName);
        return this;
    }

    //***   fill last name field   ***//
    public NewSCPage type_lastName(String text) {
        type(lName, text);
        log.info("last name: " + lName);
        return this;
    }

    //***   fill tel number field   ***//
    public NewSCPage type_phoneNumber(String text) {
        type(phNumber, text);
        log.info("phone number: " + phNumber);
        return this;
    }

    //***   fill branch name field   ***//
    public NewSCPage type_branchName(String text) {
        type(brName, text);
        log.info("branch name: " + brName);
        return this;
    }

    // *** open-close dropdown "שיטת המשלוח" *** //
    public NewSCPage select_shipMode() {
        double_click(shipMode);
        log.info("delivery method dropdown");
        return this;
    }

    // *** open dropdown  "תיאור התקלה"  *** //
    public NewSCPage select_descFault() {
        click(descFault);
        sleep(2000);
        click(reasonFault);
        log.info("description of fault dropdown");
        return this;
    }

    // *** fill the text field "פירוט התקלה"  *** //
    public NewSCPage type_detailsFault(String text) {
        type(detailsFault, text);
        log.info("details of fault: " + text);
        return this;
    }

    // *** select checkbox from the equipment list *** //
    public void select_equipment(String name) {
        log.info("you try select checkbox with name: " + name);
        WebElement elem = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
        click(elem);
    }

    public boolean chekIsSelect_equipment(String name) {

        WebElement elem = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
     return   elem.isSelected();

    }

    // *** term and conditions checkbox *** //
    public NewSCPage termCondition_checkBox() {
        click(termCheck);
        log.info("term & cond");
        return this;
    }

    // *** button "שלח"  *** //
    public NewSCPage click_submit() {
        click(submit);
        return this;
    }

    // Call Number created
    @FindBy(css = "[id=callID]")
    private WebElement new_ServiceCall;

    // back to SC's list
    @FindBy(css = ".btn.gohomebtn")
    private WebElement back_SClist;
    public NewSCPage back_MainList (){
         wait.until(ExpectedConditions.visibilityOf(new_ServiceCall));
         click(back_SClist);
         log.info("New Serivce Call: " +getText(new_ServiceCall)+ "is created");
         return this;
     }

     public List<String> eq () {
         List<String> listEq = new ArrayList<String>();
         listEq.add("רובוט");
         listEq.add("ספ\"כ");
         listEq.add("כבל שחור בספ\"כ");
         listEq.add("עגלה");
         listEq.add("שלט");
         listEq.add("טרייד אין");
         listEq.add("פירוק");
         return listEq;
     }

}


