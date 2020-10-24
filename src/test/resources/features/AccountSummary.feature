Feature:Account Summary Page

  Background:

    Given the user is logged in

    Scenario:Zero - Account Summary page verification
      Given the user enters valid username and password
      Then the page title should be Zero - Account Summary

  Scenario: Account Types
    Then the page should have the following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Account table
    Then Credit Accounts table should have the following columns
      | Account     |
      | Credit Card |
      | Balance     |