Feature: Navigating to specific accounts in Accounts Activity

    Scenario: Savings account redirect
      Given the user is logged in
      Then the user clicks on "Account Summary" tab
      Then the user clicks on "Savings" link
      And the page title should be "Zero - Account Activity"
      And the default option of the account dropdown should be "Savings"

    Scenario: 
      Given the user is logged in
      When the user clicks on "Account Summary" tab
      Then the user clicks on "Brokerage" link
      And the page title should be "Zero - Account Activity"
      And the default option of the account dropdown should be "Brokerage"

    Scenario:
      Given the user is logged in
      When the user clicks on "Account Summary" tab
      Then the user clicks on "Checking" link
      And the page title should be "Zero - Account Activity"
      And the default option of the account dropdown should be "Checking"

    Scenario:
      Given the user is logged in
      When the user clicks on "Account Summary" tab
      Then the user clicks on "CreditCard" link
      And the page title should be "Zero - Account Activity"
      And the default option of the account dropdown should be "Credit Card"
  @wip
    Scenario:
      Given the user is logged in
      When the user clicks on "Account Summary" tab
      Then the user clicks on "Loan" link
      And the page title should be "Zero - Account Activity"
      And the default option of the account dropdown should be "Loan"



