Feature: Navigating to specific accounts in Accounts Activity
  Background:
    Given the user is logged in
    Then the user clicks on "Account Summary" tab

    Scenario: Savings account redirect
      Then the user clicks on "Savings" link
      And the page title should be "Zero - Account Activity"
      And the default option of the account dropdown should be "Savings"

    Scenario:
      Then the user clicks on "Brokerage" link
      And the page title should be "Zero - Account Activity"
      And the default option of the account dropdown should be "Brokerage"

    Scenario:
      Then the user clicks on "Checking" link
      And the page title should be "Zero - Account Activity"
      And the default option of the account dropdown should be "Checking"

    Scenario:
      Then the user clicks on "CreditCard" link
      And the page title should be "Zero - Account Activity"
      And the default option of the account dropdown should be "Credit Card"

    Scenario:
      Then the user clicks on "Loan" link
      And the page title should be "Zero - Account Activity"
      And the default option of the account dropdown should be "Loan"



