package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
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
    public void thePageTitleShouldBe(String title) {
        String expectedTitle=title;
        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Given("the default option of the account dropdown should be {string}")
    public void the_default_option_of_the_account_dropdown_should_be(String accountDefault) {
        AccountActivity accountActivity = new AccountActivity();
        String expectedResult= accountDefault;
        String actualResult=accountActivity.accountButton.getText();

    }

    @Given("Account dropdown should have the following options")
    public void account_dropdown_should_have_the_following_options(List<String> expectedList) {
        List<String> actualList = new AccountActivity().getAccountDrop();

        Assert.assertEquals(expectedList,actualList);
        System.out.println("actualList = " + actualList);
        System.out.println("expectedList = " + expectedList);


    }

}
