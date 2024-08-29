package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshotUtil {

    public static void getScreenshot(WebDriver driver, String testname) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File dst = new File(".\\ScreenShots\\"+testname+".png");
        FileUtils.copyFile(src, dst);
    }
}
