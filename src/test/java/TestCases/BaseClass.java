package TestCases;


import Utilities.ReadConfig;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    ReadConfig rConfig;

    {
        try {
            rConfig = new ReadConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    String baeUrl = rConfig.getBaseUrl();                better to create variables in class , where we write method
    String browser = rConfig.getBrowser();

    public static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        switch (browser.toLowerCase()){
            case("chrome"):
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case("edge"):
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                driver = null;
                throw new RuntimeException(" Browser not found ");

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();
        driver.quit();
        Thread.sleep(2000);

    }

}
