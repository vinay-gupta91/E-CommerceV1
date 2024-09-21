package TestCases;

import PageObject.AccountCreationPage;
import PageObject.IndexPage;
import PageObject.MyAccountPage;
import PageObject.RegistrationPage;
import Utilities.CaptureScreenshotUtil;
import Utilities.DataProvidersUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyAccountTestDDT extends BaseClass{


    @Test(dataProvider = "registerData" , dataProviderClass = DataProvidersUtil.class, priority = 0)
    public void verifyRegistrationLogins(String email, String firstName, String lastName, String password, String day, String month
    , String year, String expectedUsername) throws InterruptedException {
//      Navigate to Sign-In Page
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickSignInButton();

//      Register a new user
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.setRegisterEmail(email);
        myAccountPage.clickSubmitRegister();


//      Fill new user Form
        AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
        accountCreationPage.clickMaleGender();
        accountCreationPage.setFirstName(firstName);
        accountCreationPage.setLastName(lastName);
        accountCreationPage.setPassWord(password);
        accountCreationPage.setDay(day);
        accountCreationPage.setMonth(month);
        accountCreationPage.setYear(year);
        accountCreationPage.clickSubmitRegister();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        String ActualUserName= registrationPage.getUserName();
        Assert.assertEquals(ActualUserName, expectedUsername, "Actual Username not matches with Expected Username");

    }

    @Test(dataProvider = "loginData" , dataProviderClass = DataProvidersUtil.class, priority = 1)
    public void verifyLogins (String email, String password , String expectUserName) throws InterruptedException, IOException {
//      Navigate to Sign-In Page
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickSignInButton();


        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.setLoginEMail(email);
        myAccountPage.setLoginPassword(password);
        myAccountPage.clickLoginButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        String ActualUserName= registrationPage.getUserName();
        if (ActualUserName.equals(expectUserName)){
            Assert.assertTrue(true);
        }
        else {
            CaptureScreenshotUtil.getScreenshot(driver, "verifyLogin");
            Assert.assertTrue(false, "Actual Username not matches with Expected Username");
        }

    }

}
