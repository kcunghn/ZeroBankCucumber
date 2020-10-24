Feature: Account Activity page
 Background:
    Given the user is logged in
    And the user clicks on "Account Activity" tab

  Scenario: Zero - Account Page Title Verification
   Then the page title should be "Zero - Account Activity"
@wip
    Scenario: Account Dropdown
      And the default option of the account dropdown should be "Savings"
      And Account dropdown should have the following options
      | Savings    |
      | Checking   |
      | Loan       |
      |Credit card |
      |Brokerage   |
  Scenario: Transactions



