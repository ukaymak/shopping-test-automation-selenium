package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartSummaryElements {

    public WebElement productName;
    public WebElement item;
    public WebElement total;
    public WebElement pageName;



    public ShoppingCartSummaryElements(WebDriver driver) {

        productName     = driver.findElement(By.cssSelector("#cart_summary .product-name a"));
        item            = driver.findElement(By.cssSelector("#cart_summary .cart_quantity .cart_quantity_input "));
        total           = driver.findElement(By.cssSelector("#total_price"));
        pageName        = driver.findElement(By.cssSelector(".breadcrumb .navigation_page"));


    }
}
