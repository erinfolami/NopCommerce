package com.NopCommerce.tests;

import com.NopCommerce.pageObjects.LoginPage;
import com.NopCommerce.utils.ReadConfig;
import com.NopCommerce.utils.Screenshot;
import org.apache.commons.io.FileUtils;
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


    }

    @BeforeMethod
    public void before_method() {
        driver.get(base_url);
        logger.info("Url is opened......");
        lp = new LoginPage(driver);
    }


    @AfterMethod
    public void captureScreen(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Screenshot.get_screenshot(driver, result.getName());
        }
    }

//    @AfterMethod
//    public void logout_after_method() {
//        lp.logout();
//        logger.info("Logout Out");
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
