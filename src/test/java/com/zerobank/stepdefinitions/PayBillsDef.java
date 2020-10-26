package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class PayBillsDef {
    @When("the user select the {string}")
    public void the_user_select_the(String payOption) {
        PayBills pays= new PayBills();
        pays.setPayee();
        pays.setAccount();


    }

    @And("the user enters the following amount: {string}")
    public void theUserEntersTheFollowingAmount(String money) {

        new PayBills().amount.sendKeys(money);

    }

    @When("the user enters the following date: {string}")
    public void the_user_enters_the_following_date(String date) {
        new PayBills().date.sendKeys(date);

    }

    @When("the user enters the following description: {string}")
    public void the_user_enters_the_following_description(String payment) {
        new PayBills().description.sendKeys("Iphone 12");

    }

    @When("the user clicks on Pay button")
    public void the_user_clicks_on_Pay_button() {
        new PayBills().submitBtn.click();
        BrowserUtils.waitFor(4);


    }

    @Then("the following message should be displayed: {string}")
    public void theFollowingMessageShouldBeDisplayed(String message) {
        String actualMessage = new PayBills().confMessage.getText();

    }


    @And("the alert message is {string}")
    public void theAlertMessageIs(String alertText) {

        String actualText = Driver.get().switchTo().alert().getText();
        System.out.println("actualText = " + actualText);
        Assert.assertEquals(alertText,actualText);


    }

    @Then("the following message shouldn't be displayed: {string}")
    public void theFollowingMessageShouldnTBeDisplayed(String expectedResult) {
        String actualMessage = new PayBills().confMessage.getText();
        Assert.assertNotEquals(expectedResult,actualMessage);


    }
}
