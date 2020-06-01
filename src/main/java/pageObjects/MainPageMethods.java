package pageObjects;

import common.WaitFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MainPageMethods {
    private WebDriver driver;
    private WaitFunctions waitFunctions;

    public MainPageMethods(WebDriver driver) {
        this.driver = driver;
        this.waitFunctions = new WaitFunctions(driver);
    }

}
