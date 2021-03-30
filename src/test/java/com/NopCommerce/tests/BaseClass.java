package com.NopCommerce.tests;

import com.NopCommerce.pageObjects.AddNewCustomerPage;
import com.NopCommerce.pageObjects.LoginPage;
import com.NopCommerce.utils.ReadConfig;
import com.NopCommerce.utils.Screenshot;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    private final String base_url = readConfig.getUrl();
    private final String useremail = readConfig.get_useremail();
    private final String password = readConfig.get_password();
    private final String chromepath = readConfig.get_chromepath();
    private final String firefoxpath = readConfig.get_firefoxpath();

    public WebDriver driver;
    public Logger logger;
    public LoginPage lp;
    public AddNewCustomerPage addCustomer;

    @BeforeClass
    @Parameters("browser")
    public void setup(String br) {
        this.logger = Logger.getLogger("test");
        PropertyConfigurator.configure("./src/main/resources/config/log4j.properties");

        if (br.equals("chrome")) {
            ///System.getProperty("user.dir")  gets the full path of project directory
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readConfig.get_chromepath());
            this.driver = new ChromeDriver();
            logger.info("Starting Chrome Driver");
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readConfig.get_firefoxpath());
            this.driver = new FirefoxDriver();
            logger.info("Starting Firefox Driver");
        } else {
            logger.info("Browser not specified");
            System.out.println("Browser not specified");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        this.lp = new LoginPage(driver);
        this.addCustomer = new AddNewCustomerPage(driver);

    }

    @BeforeMethod
    public void before_method() {
        driver.get(base_url);
        logger.info("Url is opened......");
    }


    @AfterMethod
    public void captureScreen(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Screenshot.get_screenshot(driver, result.getName());
        }
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    public static String randomstring(){
        String generateString = RandomStringUtils.randomAlphabetic(6);
        return generateString;
    }

    public static String randomNum(){
        String generateNum = RandomStringUtils.random(6);
        return generateNum;
    }


}
