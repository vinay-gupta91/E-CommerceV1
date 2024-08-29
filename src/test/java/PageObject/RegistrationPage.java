package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver d){
        driver = d;
        PageFactory.initElements(d, this);
    }

    @FindBy(xpath = "//a[@title=\"View my customer account\"]")  WebElement UserName ;

    public String getUserName(){
        return UserName.getText();
    }
}
