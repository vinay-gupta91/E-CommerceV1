package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver driver;
    //  create object of Webdriver
    public MyAccountPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(d, this);
    }

    //  Identify WebElements
    @FindBy(id = "email_create")  private WebElement registerEmailInputField;
    @FindBy(css = "button#SubmitCreate")  private WebElement submitRegisterButton;
    @FindBy(id = "email") private WebElement loginEmail;
    @FindBy(id = "passwd") private WebElement loginPassword;
    @FindBy(id = "SubmitLogin")  private WebElement loginButton;
    @FindBy(className = "logout") private WebElement signOutButton;

    //  Perform Actions on WebElements
    public void setRegisterEmail(String email) {
        registerEmailInputField.sendKeys(email);
    }
    public void clickSubmitRegister() {
        submitRegisterButton.click();
    }

    public void setLoginEMail(String email) {
        loginEmail.sendKeys(email);
    }
    public void setLoginPassword(String password) {
        loginPassword.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickSignOut() {
        signOutButton.click();
    }

}
