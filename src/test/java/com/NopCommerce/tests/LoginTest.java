package com.NopCommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseClass {

    @Test
    public void login_test() throws InterruptedException {
        logger.info("Login test started");
        String expected_title = "Dashboard / nopCommerce administrationsss";
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), expected_title);
        logger.info("LogIn Test Passed");
    }

//    @Test
//    public void z() throws InterruptedException {
//        logger.info("22222 started");
//        String expected_title = "Dashboard / nopCommerce administration";
//        Thread.sleep(2000);
//        Assert.assertEquals(driver.getTitle(), expected_title);
//        logger.info("Test 2222 Passed");
//    }


}
