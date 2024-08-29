package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;
    //  create object of Webdriver
    public MyAccountPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(d, this);
    }

    //  Identify WebElements
    @FindBy(id = "email_create")  WebElement EmailAddress;
    @FindBy(css = "button#SubmitCreate")  WebElement SubmitCreate;
    @FindBy(id = "email") WebElement RegisteredEmail;
    @FindBy(id = "passwd") WebElement RegisteredPassword;
    @FindBy(id = "SubmitLogin")  WebElement SubmitLogin;
    @FindBy(className = "logout") WebElement SignOut;

    //  Perform Actions on WebElements
    public void setEmailAddress(String emailID) {
        EmailAddress.sendKeys(emailID);
    }
    public void clickSubmitCreate() {
        SubmitCreate.click();
    }

    public void setRegisteredEmail(String emailId) {
        RegisteredEmail.sendKeys(emailId);
    }
    public void setRegisteredPassword(String pswrd) {
        RegisteredPassword.sendKeys(pswrd);
    }
    public void clickSubmitLogin() {
        SubmitLogin.click();
    }

    public void clickOnSignOut() {
        SignOut.click();
    }

}
