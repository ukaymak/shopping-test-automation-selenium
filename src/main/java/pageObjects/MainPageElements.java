package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageElements {

    public WebElement signIn;


    public MainPageElements(WebDriver driver) {

        signIn      = driver.findElement(By.cssSelector(".login"));
    }
}
