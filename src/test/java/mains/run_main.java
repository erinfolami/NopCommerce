package mains;


import com.NopCommerce.utils.ReadConfig;
import com.NopCommerce.utils.Screenshot;
import com.NopCommerce.utils.XLUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Arrays;


public class run_main {

    public String [][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"/src/test/java/com/NopCommerce/data/LoginData.xlsx";

        int rownum=XLUtils.getRowCount(path, "Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
            }
        }

        return logindata;

    }

    public static void main(String[] args) throws IOException {
//        ReadConfig readConfig = new ReadConfig();
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readConfig.get_chromepath());
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://web.facebook.com/?_rdc=1&_rdr");

        //read excel
        run_main r = new run_main();
        System.out.println(r);
        for(String[] i:r.getData()) {
            System.out.println(Arrays.toString(i));
        }

    }
}
