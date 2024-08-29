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

    String BaseUrl = rConfig.getBaseUrl();

    @Test(priority = 0)
    public void verifyRegistrationLogin () throws InterruptedException {
        driver.get(BaseUrl);
        IndexPage indxPg = new IndexPage(driver);
        indxPg.clickSignIn();
        Thread.sleep(2000);

        MyAccountPage myAccPg = new MyAccountPage(driver);
        myAccPg.setEmailAddress("adfdfer@gmail.com");
        myAccPg.clickSubmitCreate();

        AccountCreationPage acCrtPg = new AccountCreationPage(driver);
        acCrtPg.clickMaleGender();
        acCrtPg.setFirstName("Abcfn");
        acCrtPg.setLastName("xyzLN");
        acCrtPg.setPassWord("qwerty1234");
        acCrtPg.setDay("20");
        acCrtPg.setMonth("4");
        acCrtPg.setYear("1993");
        acCrtPg.clickSubmitRegister();
        Thread.sleep(2000);

        RegistrationPage rgPg = new RegistrationPage(driver);
        String ActualUserName= rgPg.getUserName();
        Assert.assertEquals(ActualUserName, "Abcfn xyzLN" );
        Thread.sleep(5000);

    }

    @Test(priority = 1)
    public void verifyLogin () throws InterruptedException, IOException {
        driver.get(BaseUrl);
        IndexPage indxPg = new IndexPage(driver);
        indxPg.clickSignIn();
        Thread.sleep(2000);
        MyAccountPage myAccPg = new MyAccountPage(driver);
        myAccPg.setRegisteredEmail("abc09@gmail.com");
        myAccPg.setRegisteredPassword("qwerty1234");
        myAccPg.clickSubmitLogin();
        Thread.sleep(2000);

        RegistrationPage rgPg = new RegistrationPage(driver);
        String ActualUserName= rgPg.getUserName();
        if (ActualUserName.equals("Abcfn xyzLN")){
            Assert.assertTrue(true);
        }
        else {
            CaptureScreenshotUtil.getScreenshot(driver, "verifyLogin");
            Assert.assertTrue(false);
        }


    }



}
