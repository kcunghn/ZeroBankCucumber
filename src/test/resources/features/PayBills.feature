Feature: Pays Bills Page
  Background:
    Given the user is logged in
    And the user clicks on "Pay Bills" tab

    Scenario: Pay Bills page verification
      Then the page title should be "Zero - Pay Bills"

Scenario: Making successful payment
  When the user select the "Payee Options"
  And the user select the "Account Option"
  And the user enters the following amount: "1000"
  And the user enters the following date: "2020-10-08"
  And the user enters the following description: "iphone payment"
  And the user clicks on Pay button
  Then the following message should be displayed: "The payment was successfully submitted."

    Scenario:Trying to make payment without entering date
      When the user select the "Payee Options"
      And the user select the "Account Option"
      And the user enters the following amount: "1000"
      And the user enters the following description: "iphone payment"
      And the user clicks on Pay button
      And the alert message is "Please fill in this fields"

  Scenario: Trying to make payment without entering amount
    When the user select the "Payee Options"
    And the user select the "Account Option"
    And the user enters the following date: "2020-10-08"
    And the user enters the following description: "iphone payment"
    And the user clicks on Pay button
    And the alert message is "Please fill in this fields"

  Scenario: Entering alphabetical or special characters to the Amount field
    When the user select the "Payee Options"
    And the user select the "Account Option"
    And the user enters the following amount: "erhan"
    And the user enters the following date: "2020-10-08"
    And the user enters the following description: "iphone payment"
    And the user clicks on Pay button
    Then the following message shouldn't be displayed: "The payment was successfully submitted."

    Scenario: Entering alphabetical characters to the Date field
      When the user select the "Payee Options"
      And the user select the "Account Option"
      And the user enters the following amount: "1000"
      When the user enters the following date: "abcdefg"
      And the user clicks on Pay button
      And the alert message is "Please fill in this fields"






