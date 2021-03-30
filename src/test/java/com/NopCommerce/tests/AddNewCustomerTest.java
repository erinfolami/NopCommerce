package com.NopCommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;



public class AddNewCustomerTest extends BaseClass{

    @Test
    public void AddNewCustomer() throws InterruptedException {
        logger.info("AddNewCustomer test started");
        lp.login("admin@yourstore.com","admin");
        addCustomer.clickOnMenuBar();
        addCustomer.clickOncustomersMenu();
        addCustomer.lnkCustomersMenuItem();
        addCustomer.clickOnAddnew();
        String email = randomstring() + "@gmail.com";
        addCustomer.inputEmail(email);
        String password = randomNum();
        addCustomer.inputPassword(password);
        addCustomer.setGender("Male");
        addCustomer.setNewsletter();
        addCustomer.setCustomerRoles("Registered");
        addCustomer.setAdminContent();
        addCustomer.save();

        logger.info("Validation Started");

        String AlertTxt = addCustomer.getAlertTxt();
        if (AlertTxt.contains("The new customer has been added successfully.")){
            Assert.assertTrue(true);
            logger.info("Test passed");
        }
        else{
            logger.info("AddNewCustomer test failed");
            Assert.assertTrue(false);
        }


    }
}
