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

    public ReadConfig readConfig;

    {
        try {
            readConfig = new ReadConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final String baseURL = readConfig.getBaseUrl();               // better to create variables in class , where we write method
    private String browser = readConfig.getBrowser();

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
                throw new RuntimeException(" Configured Browser ::"+browser+ ":: not supported");

        }
        driver.get(this.baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

}
