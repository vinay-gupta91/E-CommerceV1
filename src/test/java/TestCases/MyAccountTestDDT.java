package TestCases;

import DataProviders.AllDataProviders;
import PageObject.AccountCreationPage;
import PageObject.IndexPage;
import PageObject.MyAccountPage;
import PageObject.RegistrationPage;
import Utilities.CaptureScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyAccountTestDDT extends BaseClass{

    String BaseUrl2 = rConfig.getBaseUrl();

    @Test(dataProvider = "registerData" , dataProviderClass = AllDataProviders.class)
    public void verifyRegistrationLogins(String a, String b, String c, String d, String e
    , String f, String g, String h) throws InterruptedException {
        driver.get(BaseUrl2);
        IndexPage indxPg = new IndexPage(driver);
        indxPg.clickSignIn();
        Thread.sleep(2000);

        MyAccountPage myAccPg = new MyAccountPage(driver);
        myAccPg.setEmailAddress(a);
        myAccPg.clickSubmitCreate();

        AccountCreationPage acCrtPg = new AccountCreationPage(driver);
        acCrtPg.clickMaleGender();
        acCrtPg.setFirstName(b);
        acCrtPg.setLastName(c);
        acCrtPg.setPassWord(d);
        acCrtPg.setDay(String.valueOf(e));
        acCrtPg.setMonth(String.valueOf(f));
        acCrtPg.setYear(String.valueOf(g));
        acCrtPg.clickSubmitRegister();
        Thread.sleep(3000);

        RegistrationPage rgPg = new RegistrationPage(driver);
        String ActualUserName= rgPg.getUserName();
        Assert.assertEquals(ActualUserName, h);
        Thread.sleep(5000);

    }

    @Test(dataProvider = "loginData" , dataProviderClass = AllDataProviders.class)
    public void verifyLogins (String email, String pswrd , String ExpctUserName) throws InterruptedException, IOException {
        driver.get(BaseUrl2);
        IndexPage indxPg = new IndexPage(driver);
        indxPg.clickSignIn();
        Thread.sleep(2000);
        MyAccountPage myAccPg = new MyAccountPage(driver);
        myAccPg.setRegisteredEmail(email);
        myAccPg.setRegisteredPassword(pswrd);
        myAccPg.clickSubmitLogin();
        Thread.sleep(2000);

        RegistrationPage rgPg = new RegistrationPage(driver);
        String ActualUserName= rgPg.getUserName();
        if (ActualUserName.equals(ExpctUserName)){
            Assert.assertTrue(true);
        }
        else {
            CaptureScreenshotUtil.getScreenshot(driver, "verifyLogin");
            Assert.assertTrue(false);
        }

    }

}
