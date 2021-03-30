package mains;


import com.NopCommerce.utils.ReadConfig;
import com.NopCommerce.utils.Screenshot;
import com.NopCommerce.utils.XLUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;
import java.util.Arrays;


public class run_main{

    public static String randomstring(String age){
        String a = "I am %s years old".formatted(age);
        return a;
    }

    public static void main(String[] args) {
        System.out.println(randomstring("S"));
    }


    }
