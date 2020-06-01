package pageObjects;

import common.WaitFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Log;

import java.util.List;

public class CreateAccountPageMethods {

    private WebDriver driver;
    private WaitFunctions waitFunctions;

    public CreateAccountPageMethods(WebDriver driver) {
        this.driver = driver;
        this.waitFunctions = new WaitFunctions(driver);
    }


    public void stateSelect() throws  Exception {

        //WebElement element = driver.findElement(By.id("gbqfd"));
        driver.findElement(By.cssSelector("label[for='id_state']")).click();

        WebElement element = driver.findElement(By.cssSelector(".id_state #uniform-id_state span"));
        Actions builder = new Actions(driver);
        builder.moveToElement( element ).sendKeys("Alabama").perform();
    }

    public boolean checkAccount(){
        try{
            if (driver.findElement(By.cssSelector(".header_user_info .account")).isDisplayed() == true){
                Log.info("Account check is completed");
            }

        } catch (Exception e){
            Log.info("Account check is failed");
            return false;

        }
        return true;
    }

}
