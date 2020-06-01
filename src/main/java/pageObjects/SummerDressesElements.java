package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummerDressesElements {

    public WebElement cart;


    public SummerDressesElements(WebDriver driver) {

        cart      = driver.findElement(By.cssSelector(".shopping_cart>a"));
    }
}
