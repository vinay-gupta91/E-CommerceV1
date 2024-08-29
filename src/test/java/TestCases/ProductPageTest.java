package TestCases;

import PageObject.IndexPage;
import PageObject.MyAccountPage;
import PageObject.ProductPage;
import Utilities.CaptureScreenshotUtil;
import Utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductPageTest extends BaseClass {

    String BaseUrl = rConfig.getBaseUrl();
    String DefaultUsername = rConfig.getDefaultUsername();
    String DefaultPassword = rConfig.getDefaultPassword();
    String DefaultProductSearch = rConfig.getDefaultProductSearch();


    @Test
    public void searchProduct() throws InterruptedException, IOException {
        driver.get(BaseUrl);

        IndexPage indxPg = new IndexPage(driver);
        indxPg.clickSignIn();
        Thread.sleep(2000);

        MyAccountPage myAccPg = new MyAccountPage(driver);
        myAccPg.setRegisteredEmail(DefaultUsername);
        myAccPg.setRegisteredPassword(DefaultPassword);
        myAccPg.clickSubmitLogin();

        ProductPage prpg = new ProductPage(driver);
        prpg.setSearchBox(DefaultProductSearch);
        prpg.clickOnSubmitSearch();

        String ActualValue =  prpg.getSearchedProduct();
        Thread.sleep(3000);


        if (ActualValue.contains(DefaultProductSearch)){
            Assert.assertTrue(true);
            myAccPg.clickOnSignOut();
        }
        else {
            CaptureScreenshotUtil.getScreenshot(driver, "SearchProduct");
            Assert.assertTrue(false);
        }

    }

    @Test
    public void BuyProduct() throws InterruptedException, IOException {
        driver.get(BaseUrl);

        IndexPage indxPg = new IndexPage(driver);
        indxPg.clickSignIn();
        Thread.sleep(2000);

        MyAccountPage myAccPg = new MyAccountPage(driver);
        myAccPg.setRegisteredEmail(DefaultUsername);
        myAccPg.setRegisteredPassword(DefaultPassword);
        myAccPg.clickSubmitLogin();

        ProductPage prpg = new ProductPage(driver);
        prpg.setSearchBox(DefaultProductSearch);
        prpg.clickOnSubmitSearch();

        String ActualValue = prpg.getSearchedProduct();
        Thread.sleep(3000);
    }
}
