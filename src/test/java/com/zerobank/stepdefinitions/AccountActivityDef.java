package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivityDef {
    @And("the user clicks on {string} tab")
    public void theUserClicksOnTab(String tab) {
    new AccountSummary().navigateToModule(tab);
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Given("the default option of the account dropdown should be {string}")
    public void the_default_option_of_the_account_dropdown_should_be(String expectedDefault) {
        AccountActivity accountActivity = new AccountActivity();
        String actualResult=accountActivity.selectedDropDown();

        Assert.assertEquals(expectedDefault,actualResult);

    }

    @Given("Account dropdown should have the following options")
    public void account_dropdown_should_have_the_following_options(List<String> expectedList) {
        List<String> actualList = new AccountActivity().getAccountDrop();

        Assert.assertEquals(expectedList,actualList);
        System.out.println("actualList = " + actualList);
        System.out.println("expectedList = " + expectedList);
    }
    @Given("Transactions table should have the following column names")
    public void transactions_table_should_have_the_following_column_names(List<String> table) {

        List<String> actualTable = BrowserUtils.getElementsText(new AccountActivity().transactionTable);

        Assert.assertEquals(table,actualTable);
        System.out.println("actualTable = " + actualTable);


    }
    @And("the user clicks on {string} link")
    public void theUserClicksOnLink(String savingBtn) {
        new AccountSummary().getAccountSummary(savingBtn);


    }

}
