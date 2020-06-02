import common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;
import utilities.Log;

@Listeners(TestListener.class)
public class ShoppingTest {

    public WebDriver webDriver;
    public WaitFunctions waitFunctions;
    public CommonFunctions commonFunctions;

    public ShoppingTest() throws Exception {

        webDriver = DriverSettings.getDriverInstance("Chrome");
        waitFunctions = new WaitFunctions(webDriver);
        commonFunctions = new CommonFunctions(webDriver);
    }


    @Test(priority = 0)
    public void statusControlForIntegrationTest() throws Exception {
        ApiTestMethods apiTestMethods = new ApiTestMethods();
        Assert.assertEquals(200,apiTestMethods.status());
        Log.info("Status is 200, successful");

    }
    @Test(priority = 1)
    public void goToSignInPage() throws  Exception {

        MainPageElements mainPageElements = new MainPageElements(webDriver);
        mainPageElements.signIn.click();
        Log.info("Go to Sign in Page");
        waitFunctions.threadSleep(5);

    }

    @Test(priority = 2)
    public void enterEmailForCreateAnAccount() throws  Exception {
        ReadFileData readFileData = new ReadFileData();
        AuthenticationPageElements authenticationPageElements = new AuthenticationPageElements(webDriver);
        authenticationPageElements.emailInputBox.sendKeys(readFileData.readData("email"));
        authenticationPageElements.createAccountButton.click();
        waitFunctions.threadSleep(5);

    }

    @Test(priority = 3)
    public void createAccount() throws  Exception {

        ReadFileData readFileData = new ReadFileData();
        CreateAccountPageElements createAccountPageElements = new CreateAccountPageElements(webDriver);
        createAccountPageElements.titleMrCheckbox.click();

        createAccountPageElements.firstName.sendKeys(readFileData.readData("firstName"));
        waitFunctions.threadSleep(2);
        Log.info("First Name has been entered");

        createAccountPageElements.lastName.sendKeys(readFileData.readData("lastName"));
        waitFunctions.threadSleep(2);
        Log.info("Last Name has been entered");

        createAccountPageElements.password.sendKeys(readFileData.readData("password"));
        waitFunctions.threadSleep(2);
        Log.info("Password has been entered");

        createAccountPageElements.address.sendKeys(readFileData.readData("address"));
        waitFunctions.threadSleep(2);
        Log.info("Address has been entered");

        createAccountPageElements.city.sendKeys(readFileData.readData("city"));
        waitFunctions.threadSleep(2);
        Log.info("City has been entered");

        CreateAccountPageMethods createAccountPageMethods = new CreateAccountPageMethods(webDriver);
        createAccountPageMethods.stateSelect();
        Log.info("State has been selected");

        createAccountPageElements.postalCode.sendKeys(readFileData.readData("postal"));
        waitFunctions.threadSleep(2);
        Log.info("Postal has been entered");

        createAccountPageElements.mobilePhone.sendKeys(readFileData.readData("phone"));
        waitFunctions.threadSleep(2);
        Log.info("Phone number has been entered");

        createAccountPageElements.registerButton.click();
        Log.info("Clicked register button");

        Boolean state = createAccountPageMethods.checkAccount();
        Assert.assertTrue(state);
        Log.info("Account has been created succesfully");

    }

    @Test(priority = 4)
    public void goToSummerDressesPage() throws  Exception {

        SummerDressesMethods summerDressesMethods = new SummerDressesMethods(webDriver);
        summerDressesMethods.summerDressesCategory();
        waitFunctions.threadSleep(2);

    }

    @Test(priority = 5)
    public void selectProduct() throws Exception {
        commonFunctions.scrool(webDriver.findElement(By.cssSelector("#pagination")));
        SummerDressesMethods summerDressesMethods = new SummerDressesMethods(webDriver);
        summerDressesMethods.selectProduct();
        waitFunctions.threadSleep(2);
        summerDressesMethods.closePopUp();
        waitFunctions.threadSleep(2);

    }

    @Test(priority = 6)
    public void cartDetail() throws Exception {

        commonFunctions.scroolUp();
        SummerDressesElements summerDressesElements = new SummerDressesElements(webDriver);
        summerDressesElements.cart.click();
        waitFunctions.threadSleep(2);
        commonFunctions.scrool(webDriver.findElement(By.cssSelector("#cart_summary .product-name a")));

        ReadFileData readFileData = new ReadFileData();
        String productNameFromFile = readFileData.readData("productName");

        ShoppingCartSummaryElements shoppingCartSummaryElements = new ShoppingCartSummaryElements(webDriver);

        String pageName = shoppingCartSummaryElements.pageName.getText();
        Assert.assertEquals(pageName,"Your shopping cart");

        String productName = shoppingCartSummaryElements.productName.getText();
        Assert.assertEquals(productNameFromFile,productName);

        int item = Integer.parseInt(shoppingCartSummaryElements.item.getAttribute("value"));
        Assert.assertEquals(1,item);

        String total = shoppingCartSummaryElements.total.getText();
        Log.info("Total price = '" + total + "'");

        ShoppingCartSummaryMethods shoppingCartSummaryMethods = new ShoppingCartSummaryMethods(webDriver);
        shoppingCartSummaryMethods.summaryProceed();
        Log.info("Summary process has been completed");
        waitFunctions.threadSleep(2);

        shoppingCartSummaryMethods.addressCheck();
        waitFunctions.threadSleep(2);
        Log.info("Address process has been completed");

        shoppingCartSummaryMethods.termsOfService();
        waitFunctions.threadSleep(2);

        shoppingCartSummaryMethods.shippingProceed();
        waitFunctions.threadSleep(2);
        Log.info("Shipping process has been completed");

        shoppingCartSummaryMethods.paymentBankWire();
        waitFunctions.threadSleep(2);
        Log.info("Payment method has been choosen as bank wire");

        shoppingCartSummaryMethods.confirm();
        waitFunctions.threadSleep(2);
        Log.info("I confirmed my order");

    }

    @Test(priority = 7)
    public void orderHistory() throws Exception {

        ShoppingCartSummaryMethods shoppingCartSummaryMethods = new ShoppingCartSummaryMethods(webDriver);
        shoppingCartSummaryMethods.backOrder();
        Log.info("Navigate to Order history and details");
        waitFunctions.threadSleep(2);

    }


}
