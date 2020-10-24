package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {


    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Given("the user clicks on Sign in button")
    public void the_user_clicks_on_Sign_in_button() {
        new HomePage().signButton.click();
    }

    @Then("the user in on Login page")
    public void the_user_in_on_Login_page() {
        String expectedTitle = "Zero - Log in";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        BrowserUtils.waitFor(3);
    }

    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        new LoginPage().loginPage();

    }

    @Then("the page title should be Zero - Account Summary")
    public void the_page_title_should_be_Zero_Account_Summary() {
        String expectedTitle = "Zero - Account Summary";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("the user enters invalid username and password")
    public void the_user_enters_invalid_username_and_password() {
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("someusername");
        loginPage.password.sendKeys("somepassword");
        loginPage.submit.click();
    }

    @Then("the error message should be displayed")
    public void the_error_message_should_be_displayed() {
        String expectedMessage = "Login and/or password are wrong.";
        String actualMessage = new LoginPage().errorAlert.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("enters only valid username")
    public void enters_only_valid_username() {
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("username");
        loginPage.submit.click();
    }

    @When("enters only valid password")
    public void enters_only_valid_password() {
        LoginPage loginPage = new LoginPage();
        loginPage.password.sendKeys("password");
        loginPage.submit.click();
    }


    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginPage();
    }
}
