package com.NopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AddNewCustomerPage {

    private WebDriver driver;

    public AddNewCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @FindBy(css = ".fa.fa-bars")
    private WebElement menuBar;

    @FindBy(xpath = "//i[@class='nav-icon fas fa-tags']//parent::a[@class='nav-link']")
    WebElement lnkCustomersMenu;

    @FindBy(css = "a[href='/Admin/Customer/List'][class='nav-link'")
    WebElement lnkCustomersMenuItem;

    @FindBy(css = "a[href='/Admin/Customer/Create']")
    WebElement btnAddnew;

    @FindBy(css = "input[id='Email']")
    WebElement txtEmail;

    @FindBy(css = "input[id='Password']")
    WebElement textPassword;

    @FindBy(css = "input[id='FirstName']")
    WebElement textFistname;

    @FindBy(css = "#LastName")
    WebElement txtLastname;

    @FindBy(xpath = "//input[@id='Gender_Male']")
    WebElement btnMale;

    @FindBy(xpath = "//input[@id='Gender_Male']")
    WebElement btnFemale;

    @FindBy(css = "#DateOfBirth")
    WebElement txtDOB;

    @FindBy(xpath = "//input[@id='Company']")
    WebElement txtCompanyName;

    @FindBy(css = "//input[@id='IsTaxExempt']")
    WebElement btnIsTaxExempt;

    @FindBy(xpath = "//div[9]/div[2]/div/div/div/div")
    WebElement txtNewsletter;

    @FindBy(xpath = "//li[text()='Your store name']")
    WebElement listitemNewsletter;

    @FindBy(xpath = "//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[@title='delete']")
    WebElement clearCustomerRoles;

    @FindBy(xpath = "//div[10]/div[2]/div/div/div/div")
    WebElement txtCustomerRoles;

    @FindBy(css = "#AdminComment")
    WebElement txtAdminContent;

    @FindBy(css = ".alert.alert-success.alert-dismissable")
    WebElement alert;

    @FindBy(xpath = "//button[@name='save']")
    WebElement btnSave;


    public void clickOnMenuBar() {
        menuBar.click();
    }

    public void clickOncustomersMenu() {
        lnkCustomersMenu.click();
    }

    public void lnkCustomersMenuItem() {
        lnkCustomersMenuItem.click();
    }

    public void clickOnAddnew() {
        btnAddnew.click();
    }

    public void inputEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void inputPassword(String password) {
        textPassword.sendKeys(password);
    }

    public void inputFirstname(String Firstname) {
        textFistname.sendKeys(Firstname);
    }

    public void inputLastname(String Lastname) {
        txtLastname.sendKeys(Lastname);
    }

    public void setGender(String gender) {
        if (gender.equals("Male")) {
            btnMale.click();
        }
        if (gender.equals("Female")) {
            btnFemale.click();
        }
    }

    public void SetDateOfBirth(String DateOfBirth) {

        txtDOB.sendKeys(DateOfBirth);
    }

    public void setCompanyName(String CompanyName) {
        txtCompanyName.sendKeys(CompanyName);
    }

    public void clickIsTaxExempt() {
        btnIsTaxExempt.click();
    }

    public void setNewsletter() {
        txtNewsletter.click();
        listitemNewsletter.click();

    }

    public void setCustomerRoles(String role) {
        clearCustomerRoles.click();
        txtCustomerRoles.click();
        driver.findElement(By.xpath("//li[text()='%s']".formatted(role))).click();

    }

    public void setAdminContent() {
        txtAdminContent.sendKeys("testing");
    }

    public void save() {
        btnSave.click();
    }

    public String getAlertTxt() {
       return alert.getText();
    }
}
