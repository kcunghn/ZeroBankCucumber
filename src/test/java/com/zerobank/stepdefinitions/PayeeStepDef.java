package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PayeeStepDef {
    @Given("Add new {string} tab")
    public void add_new_tab(String string) {
        new PayBills().addNewPayee.click();

    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        BrowserUtils.waitFor(2);
        new PayBills().payeeName.sendKeys(dataTable.get("Payee Name"));
        new PayBills().payeeAddress.sendKeys(dataTable.get("Payee Address"));
        new PayBills().payeeAccount.sendKeys(dataTable.get("Account"));
        new PayBills().payeeDetails.sendKeys(dataTable.get("Payee details"));
        new PayBills().submitPayee.click();


    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String expectedResult) {
        String actualResult = new PayBills().alert.getText();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void theUserAccessesThePurchaseForeignCurrencyCashTab() {
        new PayBills().purchaseForeignCurrency.click();
        BrowserUtils.waitFor(2);

    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencyTable) {
        List<String> actualList = new PayBills().getCurrency();

        Assert.assertEquals(currencyTable,actualList);

        System.out.println("actualList = " + actualList);

    }

    @When("user tries to calculate cost without selecting a currency")
    public void userTriesToCalculateCostWithoutSelectingACurrency() {
        PayBills payBills = new PayBills();
        payBills.getAmount.sendKeys("300");
        payBills.calculateBtn.click();
    }
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        PayBills payBills = new PayBills();
        String actualText = Driver.get().switchTo().alert().getText();
        String expectedText= "Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(expectedText,actualText);


    }


    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        new PayBills().calculateBtn.click();

    }
}
