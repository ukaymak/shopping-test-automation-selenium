package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSettings {

    public DriverSettings() {

    }

    private static ChromeDriver chromeDriver = null;
    private static FirefoxDriver firefoxDriver = null;


    public static WebDriver getDriverInstance(String browser) {

        if (browser.equalsIgnoreCase("Chrome")) {
            if (chromeDriver == null) {
                ChromeOptions chromeOptions = new ChromeOptions();

                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("disable-dev-shm-usage");

                String workingDir = System.getProperty("user.dir");

                System.setProperty("webdriver.chrome.driver", workingDir + "/src/main/resources/drivers/chromedriver.exe");

                chromeDriver = new ChromeDriver(chromeOptions);

                chromeDriver.manage().deleteAllCookies();
                chromeDriver.manage().window().maximize();

            }
            return chromeDriver;

        } if (browser.equalsIgnoreCase("Firefox")) {

            if(firefoxDriver == null){

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                String workingDir = System.getProperty("user.dir");
                System.setProperty("webdriver.gecko.driver", workingDir + "/src/main/resources/drivers/geckodriver.exe");

                firefoxDriver = new FirefoxDriver(firefoxOptions);

                firefoxDriver.manage().deleteAllCookies();
                firefoxDriver.manage().window().maximize();

            }
            return  firefoxDriver;
        }
        return null;
        }
    }
