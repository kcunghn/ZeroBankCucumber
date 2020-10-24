package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    public WebElement username;
    @FindBy(id = "user_password")
    public WebElement password;
    @FindBy(css = "[name='submit']")
    public WebElement submit;
    @FindBy(id = "user_remember_me")
    public WebElement keepMeSignedIn;
    @FindBy(xpath = "//h3[contains(text(),'Log in to ZeroBank')]")
    public WebElement loginPageTitle;
    @FindBy(xpath = "//a[contains(text(),'Zero Bank')]")
    public WebElement homePage;
    @FindBy(xpath ="//a[contains(text(),'Forgot your password ?')]" )
    public WebElement forgotPassword;
    @FindBy(xpath = "//div[contains(text(),'Login and/or password are wrong.')]")
    public WebElement errorAlert;


    public void loginPage(){
        username.sendKeys("username");
        password.sendKeys("password");
        submit.click();
    }

}
