package pageObjects;

import common.ReadFileData;
import common.WaitFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SummerDressesMethods {

    private WebDriver driver;
    private WaitFunctions waitFunctions;

    public SummerDressesMethods(WebDriver driver) {
        this.driver = driver;
        this.waitFunctions = new WaitFunctions(driver);
    }


    public void summerDressesCategory() throws  Exception{
        WebElement dressesTab = driver.findElement(By.cssSelector("#block_top_menu .sf-menu>li:nth-of-type(2)>a"));
        dressesTab.click();
        waitFunctions.threadSleep(2);
        WebElement summerDresses = driver.findElement(By.cssSelector("#categories_block_left .block_content li:nth-of-type(3)"));
        summerDresses.click();

    }

    public void selectProduct() throws Exception {
        ReadFileData readFileData = new ReadFileData();

        WebElement asd = driver.findElement(By.cssSelector(".product_list>li:nth-of-type(1)"));
        Actions builder = new Actions(driver);
        builder.moveToElement(asd).perform();
        WebElement product = driver.findElement(By.cssSelector(".button-container a[data-id-product='"+readFileData.readData("productID")+"']"));
        product.click();


    }

    public void closePopUp() throws Exception {

        WebElement close = driver.findElement(By.cssSelector(".cross"));
        close.click();

    }
 }
