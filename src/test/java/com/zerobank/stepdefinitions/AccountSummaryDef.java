package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryDef {
    @Then("the page should have the following account types")
    public void the_page_should_have_the_following_account_types(List<String> accountTypes) {

        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummary().accountTypes);

        Assert.assertEquals(accountTypes, actualAccountTypes);

        System.out.println("accountTypes = " + accountTypes);
        System.out.println("actualAccountTypes = " + actualAccountTypes);

    }

    @Then("Credit Accounts table should have the following columns")
    public void credit_Accounts_table_should_have_the_following_columns(List<String> accountTable) {

    List<String >actualAccountTable = BrowserUtils.getElementsText(new AccountSummary().accountTable);

    Assert.assertEquals(accountTable,actualAccountTable);


    }



}