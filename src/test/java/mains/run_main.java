package mains;


import com.NopCommerce.utils.ReadConfig;
import com.NopCommerce.utils.Screenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;


public class run_main {
    public static void main(String[] args)  {
        ReadConfig readConfig = new ReadConfig();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readConfig.get_chromepath());
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://web.facebook.com/?_rdc=1&_rdr");
        Screenshot.get_screenshot(driver,"test sshello");

    }
}
