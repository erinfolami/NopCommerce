package com.NopCommerce.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class Screenshot {
    public static void get_screenshot(WebDriver driver, String TestCaseName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File target = new File(System.getProperty("user.dir") + "/Screenshots/" + TestCaseName + ".png");
            FileUtils.copyFile(source, target);
            System.out.println("Captured screenshot");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}