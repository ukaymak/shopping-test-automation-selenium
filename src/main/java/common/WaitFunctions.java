package common;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WaitFunctions {

    private WebDriver driver;

    public WaitFunctions(WebDriver driver) {
        this.driver = driver;
    }

    public void threadSleep(int timeSecond) throws InterruptedException {

        int time = timeSecond*1000;
        Thread.sleep(time);
    }
}

