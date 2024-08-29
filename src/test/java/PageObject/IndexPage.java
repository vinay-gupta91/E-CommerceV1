package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    WebDriver driver;

//  create object of Webdriver
    public IndexPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(d, this);
    }

//  Identify WebElements
    @FindBy(css = "a.login")   WebElement SignIn;

//  Perform Actions on WebElements
    public void clickSignIn(){
        SignIn.click();
    }


}
