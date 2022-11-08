
Feature: Create vehicle costs

@wip
   Scenario: create a vehicle cost
  Given : user is already logged in and on main page
   When user clicks on more button
    And user clicks fleet button
    And user clicks Vehicle Costs button
    And user clicks create button
    And user sees the title New
    And user selects a vehicle "vehicle"
    And user selects a type "type"
    And user selects a date
    And user enters total price
    And user enters cost description
    And user clicks on save button
    Then title is changed to "Vehicle" and new table is created