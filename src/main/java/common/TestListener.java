package common;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import utilities.Log;

import java.io.File;
import java.io.IOException;


public class TestListener implements ITestListener,ISuiteListener {

    private static Logger logger = Logger.getLogger(TestListener.class);

    public TestListener(){

    }

    public void onFinish(ISuite suite) {
        DriverSettings.getDriverInstance("Chrome").quit();

    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {

        TakesScreenshot ts = (TakesScreenshot) DriverSettings.getDriverInstance("Chrome");
        File src = ts.getScreenshotAs(OutputType.FILE);

        try{
            String screenShotDir    = getScreenShotDir();
            FileUtils.copyFile(src, new File(screenShotDir + System.currentTimeMillis()+ ".png"));


        } catch ( IOException e) {
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {


    }

    public void onStart(ISuite suite) {

        ReadFileData readFileData = new ReadFileData();
        String url = readFileData.readData("URL");
        DriverSettings.getDriverInstance("Chrome").get(url);
        Log.info("Go to Page " + url + " " + " \n ");

    }

    public String getScreenShotDir(){
        String path = String.format("%s/target/output/screenShots", System.getProperty("user.dir"));
        return path;
    }


}
