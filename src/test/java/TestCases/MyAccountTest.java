package TestCases;

import PageObject.AccountCreationPage;
import PageObject.IndexPage;
import PageObject.MyAccountPage;
import PageObject.RegistrationPage;
import Utilities.CaptureScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyAccountTest extends BaseClass{

    private IndexPage indexPage;
    private MyAccountPage myAccountPage;
    private AccountCreationPage accountCreationPage;
    private RegistrationPage registrationPage;
    String loginUser = readConfig.getDefaultUsername();
    String loginPassword = readConfig.getDefaultPassword();


    @Test(priority = 0)
    public void verifyRegistrationLogin () throws InterruptedException {
        indexPage = new IndexPage(driver);            // Or we can keep this objects in seperate method to avoid repeating
        myAccountPage = new MyAccountPage(driver);
        accountCreationPage = new AccountCreationPage(driver);
        registrationPage = new RegistrationPage(driver);

        // This line added in C1m with github
        
//      Navigate to Sign-In Page
        indexPage.clickSignInButton();
        Thread.sleep(2000);

//      Register a new user
        myAccountPage.setRegisterEmail("adfdfer013@gmail.com");
        myAccountPage.clickSubmitRegister();

//      Fill new user Form
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
        String ActualUserName= registrationPage.getUserName();
        Assert.assertEquals(ActualUserName, "Abcfn xyzLN" , "Actual Username not matches with Expected Username" );
        Thread.sleep(5000);

    }

    @Test
    public void verifyLogin () throws InterruptedException, IOException {
        indexPage = new IndexPage(driver);
        registrationPage = new RegistrationPage(driver);
        myAccountPage = new MyAccountPage(driver);

        indexPage.clickSignInButton();
        Thread.sleep(2000);
        myAccountPage.setLoginEMail(loginUser);
        myAccountPage.setLoginPassword(loginPassword);
        myAccountPage.clickLoginButton();
        Thread.sleep(2000);

        String ActualUserName= registrationPage.getUserName();
        if (ActualUserName.equals("Abcfn xyzLNa")){
            Assert.assertTrue(true);
        }
        else {
            CaptureScreenshotUtil.getScreenshot(driver, "verifyLogin");
            Assert.assertTrue(false, "Actual Username not matches with Expected Username");
//            throw new RuntimeException("testing is failed vinay");
        }

    }

//    @BeforeMethod
//    public void pageSetup(){
//        indexPage = new IndexPage(driver);
//        myAccountPage = new MyAccountPage(driver);
//        accountCreationPage = new AccountCreationPage(driver);
//        registrationPage = new RegistrationPage(driver);
//    }




}
