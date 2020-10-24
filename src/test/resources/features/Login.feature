Feature: authorized users should be able to login

  Background:
    Given the user is on the homepage
    And the user clicks on Sign in button
    Then the user in on Login page

  Scenario: Login as an authorised user
    When the user enters valid username and password
    Then the page title should be Zero - Account Summary

  Scenario: Login as an unauthorised user 1
    When the user enters invalid username and password
    Then the error message should be displayed

  Scenario: Login as an unauthorised user 2
    When  enters only valid username
    Then the error message should be displayed


  Scenario: Login as an unauthorised user 3
    When enters only valid password
    Then the error message should be displayed
