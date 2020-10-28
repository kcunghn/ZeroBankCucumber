package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountActivityDef {
    @And("the user clicks on {string} tab")
    public void theUserClicksOnTab(String tab) {
        new AccountSummary().navigateToModule(tab);
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Given("the default option of the account dropdown should be {string}")
    public void the_default_option_of_the_account_dropdown_should_be(String expectedDefault) {
        AccountActivity accountActivity = new AccountActivity();
        String actualResult = accountActivity.selectedDropDown();

        Assert.assertEquals(expectedDefault, actualResult);

    }

    @Given("Account dropdown should have the following options")
    public void account_dropdown_should_have_the_following_options(List<String> expectedList) {
        List<String> actualList = new AccountActivity().getAccountDrop();

        Assert.assertEquals(expectedList, actualList);
        System.out.println("actualList = " + actualList);
        System.out.println("expectedList = " + expectedList);
    }

    @Given("Transactions table should have the following column names")
    public void transactions_table_should_have_the_following_column_names(List<String> table) {

      //  List<String> actualTable = BrowserUtils.getElementsText(new AccountActivity().transactionTable);
        List<String> actualTable = new AccountActivity().getTransactions();



        Assert.assertEquals(table, actualTable);
        System.out.println("actualTable = " + actualTable);


    }

    @And("the user clicks on {string} link")
    public void theUserClicksOnLink(String savingBtn) {
        new AccountSummary().getAccountSummary(savingBtn);


    }

    @Then("the user clicks on {string} menu")
    public void the_user_clicks_on_menu(String string) {
        new AccountActivity().findTransaction.click();
        BrowserUtils.waitFor(2);

    }

    @Then("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {


        AccountActivity accountActivity = new AccountActivity();
        accountActivity.fromDate.clear();
        accountActivity.toDate.clear();

        accountActivity.fromDate.sendKeys(string);
        accountActivity.toDate.sendKeys(string2);


    }

    @Then("click search")
    public void click_search() {
        new AccountActivity().search.click();
        BrowserUtils.waitFor(2);


    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
       /* BrowserUtils.waitFor(2);
        List<String> actualDates = BrowserUtils.getElementsText(new AccountActivity().transactionDates);
        Assert.assertEquals(toDate,actualDates.get(0));
        Assert.assertEquals(fromDate,actualDates.get(actualDates.size()-1));*/

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {


    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String date) {

        List<String> elementsDates = BrowserUtils.getElementsText(new AccountActivity().dateTable);
        for (String elementsDate : elementsDates) {
            Assert.assertFalse(elementsDate.contains(date));
        }

    }

    @When("the user enters description {string}")
    public void theUserEntersDescription(String str) {
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.description.clear();
        accountActivity.description.sendKeys(str);


    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        List<WebElement> descriptionResults = new AccountActivity().descriptionTable;
        Assert.assertTrue(descriptionResults.size() > 0);
        for (WebElement descriptionResult : descriptionResults) {
            Assert.assertTrue(descriptionResult.getText().contains("ONLINE"));
        }
    }

    @But("results table should not show descriptions containing {string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String desc) {
        List<String> elementsText = BrowserUtils.getElementsText(new AccountActivity().descriptionTable);
        System.out.println("description = " + elementsText);
        for (String s : elementsText) {
            Assert.assertFalse(s.contains(desc));
        }


    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
        List<String> elementsText = BrowserUtils.getElementsText(new AccountActivity().depositTable);
        System.out.println("deposit "+elementsText);
        System.out.println("deposittable = " + elementsText.size());
        Assert.assertTrue(elementsText.size() > 0);


    }

    @When("user selects type {string}")
    public void userSelectsType(String deposit) {
        new AccountActivity().getType(deposit);
    }

    @When("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {
        List<String> elementsText = BrowserUtils.getElementsText(new AccountActivity().withdrawalTable);
      //  System.out.println("elementsText.size() = " + elementsText.size());
        System.out.println("withDrawal = " + elementsText);
        int count = 0;

        for (int i = 0; i < elementsText.size(); i++) {
            if (elementsText.get(i).equals("null")) {
                count++;
            }

        }
        System.out.println("withdrawal = " + elementsText.size());
        System.out.println("count = " + count);
        Assert.assertTrue(count == elementsText.size());


    }
}