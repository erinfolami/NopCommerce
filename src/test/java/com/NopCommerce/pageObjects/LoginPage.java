package com.NopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement txtEmail;

    @FindBy(id = "Password")
    private WebElement txtpassword;

    @FindBy(className = "button-1")
    private WebElement btnLogin;

    @FindBy(linkText = "Logout")
    private WebElement lnkLogout;


    public void login(String email, String password) {
        txtEmail.clear();
        txtpassword.clear();
        txtEmail.sendKeys(email);
        txtpassword.sendKeys(password);
        btnLogin.click();
    }

    public void logout() {
        lnkLogout.click();
    }


}