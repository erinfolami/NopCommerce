package mains;


import com.NopCommerce.utils.ReadConfig;
import org.openqa.selenium.chrome.ChromeDriver;

public class run_main {
    public static void main(String[] args) {
        ReadConfig readConfig = new ReadConfig();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readConfig.get_chromepath());
        ChromeDriver driver = new ChromeDriver();
    }
}
