package com.NopCommerce.tests;

import com.NopCommerce.pageObjects.LoginPage;
import com.NopCommerce.utils.ReadConfig;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
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


    @BeforeClass
    @Parameters("browser")
    public void setup(String br) {
        this.logger = Logger.getLogger("test");
        PropertyConfigurator.configure("log4j.properties");

        if (br.equals("chrome")) {
            ///System.getProperty("user.dir")  gets the full path of project directory
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readConfig.get_chromepath());
            this.driver = new ChromeDriver();
            logger.info("Starting Chrome Driver");
        }
        else if (br.equals("firefox")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readConfig.get_firefoxpath());
            this.driver = new FirefoxDriver();
            logger.info("Starting Firefox Driver");
        }
        else {
            logger.info("Browser not specified");
            System.out.println("Browser not specified");
        }


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void before_method() {
        driver.get(base_url);
        logger.info("Url is opened......");
        LoginPage lp = new LoginPage(driver);
        lp.login(useremail, password);
    }
}
