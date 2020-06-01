package pageObjects;

import common.CommonFunctions;
import common.WaitFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Log;

import java.util.List;

public class ShoppingCartSummaryMethods {

    private WebDriver driver;
    private WaitFunctions waitFunctions;
    public CommonFunctions commonFunctions;

    public ShoppingCartSummaryMethods(WebDriver driver) {
        this.driver = driver;
        this.waitFunctions = new WaitFunctions(driver);
    }


    public void summaryProceed() throws Exception {
        WebElement proceedToCheckout = driver.findElement(By.cssSelector(".cart_navigation  a[title='Proceed to checkout']>span"));
        proceedToCheckout.click();

    }

    public void addressCheck() throws Exception {
        WebElement addres = driver.findElement(By.cssSelector("#uniform-id_address_delivery span"));
        addres.getText();
        if(addres.getText().equalsIgnoreCase("My address")){
            WebElement proceedToCheckoutAddress = driver.findElement(By.cssSelector(".cart_navigation button span"));
            proceedToCheckoutAddress.click();
            Log.info("Address info is choosed");
            waitFunctions.threadSleep(2);
        } else {
            Log.info("Add new Address");
        }
    }

    public void termsOfService() throws Exception {
        WebElement checkBox = driver.findElement(By.cssSelector("#uniform-cgv span"));
        checkBox.click();
        Log.info("Terms of Service checkbox has been clicked");
    }

    public void shippingProceed() throws Exception{
        WebElement shippingProceed = driver.findElement(By.cssSelector(".cart_navigation button span"));
        shippingProceed.click();
    }

    public void paymentBankWire() throws Exception{
        WebElement bankWire = driver.findElement(By.cssSelector(".bankwire span"));
        bankWire.click();

    }

    public void confirm() throws Exception{

        WebElement confirm = driver.findElement(By.cssSelector(".button-medium[type='submit'] span"));
        confirm.click();
    }

    public void backOrder() throws Exception{

        WebElement back = driver.findElement(By.cssSelector(".button-exclusive"));
        back.click();
    }




}