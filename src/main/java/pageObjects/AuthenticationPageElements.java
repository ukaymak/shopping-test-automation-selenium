package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPageElements {

    public WebElement emailInputBox;
    public WebElement createAccountButton;


    public AuthenticationPageElements(WebDriver driver) {

        emailInputBox      = driver.findElement(By.cssSelector("#email_create"));
        createAccountButton = driver.findElement(By.cssSelector("#SubmitCreate"));
    }
}
