package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPageElements {

    public WebElement titleMrCheckbox;
    public WebElement firstName;
    public WebElement lastName;
    public WebElement password;

    //address
    public WebElement address;
    public WebElement city;
    public WebElement postalCode;
    public WebElement mobilePhone;
    public WebElement registerButton;




    public CreateAccountPageElements(WebDriver driver) {

        titleMrCheckbox     = driver.findElement(By.cssSelector("#id_gender1"));
        firstName           = driver.findElement(By.cssSelector("#customer_firstname"));
        lastName            = driver.findElement(By.cssSelector("#customer_lastname"));
        password            = driver.findElement(By.cssSelector("#passwd"));

        //address
        address             = driver.findElement(By.cssSelector("#address1"));
        city                = driver.findElement(By.cssSelector("#city"));
        postalCode          = driver.findElement(By.cssSelector("#postcode"));
        mobilePhone         = driver.findElement(By.cssSelector("#phone_mobile"));
        registerButton      = driver.findElement(By.cssSelector("#submitAccount"));



    }
}
