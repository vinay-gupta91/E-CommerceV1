package TestCases;

import PageObject.AccountCreationPage;
import PageObject.IndexPage;
import PageObject.MyAccountPage;
import PageObject.RegistrationPage;
import Utilities.CaptureScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyAccountTest extends BaseClass{


    @Test(priority = 0)
    public void verifyRegistrationLogin () throws InterruptedException {

//      Navigate to Sign-In Page
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickSignInButton();
        Thread.sleep(2000);

//      Register a new user
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.setRegisterEmail("adfdfer013@gmail.com");
        myAccountPage.clickSubmitRegister();


//      Fill new user Form
        AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
        accountCreationPage.clickMaleGender();
        accountCreationPage.setFirstName("Abcfn");
        accountCreationPage.setLastName("xyzLN");
        accountCreationPage.setPassWord("qwerty1234");
        accountCreationPage.setDay("20");
        accountCreationPage.setMonth("4");
        accountCreationPage.setYear("1993");
        accountCreationPage.clickSubmitRegister();
        Thread.sleep(2000);



//      Verify Registration was successful
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String ActualUserName= registrationPage.getUserName();
        Assert.assertEquals(ActualUserName, "Abcfn xyzLN" , "Actual Username not matches with Expected Username" );
        Thread.sleep(5000);

    }

    @Test(priority = 1)
    public void verifyLogin () throws InterruptedException, IOException {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickSignInButton();
        Thread.sleep(2000);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.setLoginEMail("adfdfer013@gmail.com");
        myAccountPage.setLoginPassword("qwerty1234");
        myAccountPage.clickLoginButton();
        Thread.sleep(2000);
        String email = "adfdfer013@gmail.com";

        RegistrationPage registrationPage = new RegistrationPage(driver);
        String ActualUserName= registrationPage.getUserName();
        if (ActualUserName.equals("Abcfn xyzLN")){
            Assert.assertTrue(true, " login verified for email :"+email);
        }
        else {
            CaptureScreenshotUtil.getScreenshot(driver, "verifyLogin");
            Assert.assertTrue(false, "Actual Username not matches with Expected Username");
        }

    }



}
