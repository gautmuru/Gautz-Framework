package org.gravity.automation_framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Web Elements
    @FindBy(xpath = "//*[@id='user-name']")
    private WebElement usernamefield;

    @FindBy(xpath = "//*[@id='password'][@type='password']")
    private WebElement passwordfield;

    @FindBy(xpath = "//*[@id='login-button'][@type='submit']")
    private WebElement loginbutton;


    // Constructor to initialize the driver and web elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to enter user name
    public void enterUsername(String username) {
        usernamefield.sendKeys(username);
    }

    // Method to enter password and click sign-in
    public void enterPassword(String password) {
    	passwordfield.sendKeys(password);
        loginbutton.click();
    }

    // Method to perform the complete login flow
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
    }
}