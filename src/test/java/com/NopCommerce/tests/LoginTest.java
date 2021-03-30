package com.NopCommerce.tests;

import com.NopCommerce.utils.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTest extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void login_test(String useremail, String password) throws InterruptedException {
        logger.info("Login test started");
        lp.login(useremail, password);
        String expected_title = "Dashboard / nopCommerce administration";

        logger.info("Validation Started");
        if (driver.getTitle().equals(expected_title)) {
            Assert.assertTrue(true);
            logger.info("Login test passed");
            lp.logout();
        } else {
            logger.info("Login test failed");
            Assert.assertTrue(false);
        }

    }


    @DataProvider(name = "LoginData")
    public Object[] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/com/NopCommerce/data/LoginData.xlsx";

        int rownum = XLUtils.getRowCount(path, "sheet1");
        int colcount = XLUtils.getCellCount(path, "sheet1", 1);

        String logindata[][] = new String[rownum][colcount];

        for (int r = 1; r <= rownum; r++) {
            for (int c = 0; c < colcount; c++) {

                logindata[r - 1][c] = XLUtils.getCellData(path, "sheet1", r, c);
            }
        }
        return logindata;
    }
}
