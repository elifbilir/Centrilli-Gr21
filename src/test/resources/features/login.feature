
Feature: Centrilli app login feature
  User Story:
  As a user, I should be able to login with correct credentials accounts.
  And dashboard should be displayed.

  Scenario: Login as posmanager
    Given user is on the centrilli login page
    When user enter valid email and password
    Then user should see the dashboard

  Scenario: Negative login test
    Given user is on the centrilli login page
    When user enters invalid username and password
    Then user should see wrong login and password message displayed