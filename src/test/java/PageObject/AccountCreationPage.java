package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {
    WebDriver driver;

    public AccountCreationPage(WebDriver d){
        driver = d;
        PageFactory.initElements(d, this);
    }

    @FindBy(id = "id_gender1")
    WebElement MaleGender;

    @FindBy(id = "id_gender2")
    WebElement FemaleGender;

    @FindBy(id = "customer_firstname")
    WebElement FirstName;

    @FindBy(css = "input[name= \"customer_lastname\"]")
    WebElement LastName;

    @FindBy(css = "input[name= \"passwd\"]")
    WebElement PassWord;

    @FindBy(id = "days")
    WebElement Days;

    @FindBy(id = "months")
    WebElement Months;

    @FindBy(id = "years")
    WebElement Years;

    @FindBy(id = "submitAccount") WebElement Register;

    public void clickMaleGender(){
        MaleGender.click();
    }
    public void clickFemaleGender(){
        FemaleGender.click();
    }
    public void setFirstName(String fstName){
        FirstName.sendKeys(fstName);
    }
    public void setLastName(String lstName){
        LastName.sendKeys(lstName);
    }
    public void setPassWord(String pswd){
        PassWord.sendKeys(pswd);
    }
    public void setDay(String day){
        Select value = new Select(Days);
        value.selectByValue(day);
    }
    public void setMonth(String month){
        Select value = new Select(Months);
        value.selectByValue(month);
    }
    public void setYear(String year){
        Select value = new Select(Years);
        value.selectByValue(year);
    }
    public void clickSubmitRegister(){
        Register.click();
    }

}
