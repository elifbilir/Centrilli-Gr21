
Feature: Create vehicle costs


Scenario: create a vehicle cost
 Given : user is already logged in and on main page
 When user clicks on more button
 And user clicks fleet button
 And user clicks Vehicle Costs button
 And user clicks create button
 And user sees the title New
 And user selects a vehicle
 And user selects a type
 And user selects a date
 And user enters total price
 And user enters cost description
 And user clicks on save button
 Then title is changed to "Vehicle" and new table is created


 Scenario: can not create a vehicle cost
  Given : user is already logged in and on main page
  When user clicks on more button
  And user clicks fleet button
  And user clicks Vehicle Costs button
  And user clicks create button
  And user sees the title New
  And user clicks on save button
  Then user sees These fields are invalid error message



 Scenario: cancel creating a vehicle cost by clicking discard
  Given : user is already logged in and on main page
  When user clicks on more button
  And user clicks fleet button
  And user clicks Vehicle Costs button
  And user clicks create button
  And user sees the title New
  And user selects a vehicle
  And user clicks on discard button
  And user sees warning message
  And user clicks on ok button
  Then user is back to vehicle costs page


 Scenario: cancel creating a vehicle cost by clicking discard
  Given : user is already logged in and on main page
  When user clicks on more button
  And user clicks fleet button
  And user clicks Vehicle Costs button
  And user clicks create button
  And user sees the title New
  And user clicks on discard button
  And user is back to vehicle costs page
  Then user sees the title is vehicle costs


 Scenario: title is changed from new to "vehicle"
  Given : user is already logged in and on main page
  When user clicks on more button
  And user clicks fleet button
  And user clicks Vehicle Costs button
  And user clicks create button
  And user sees the title New
  And user selects a vehicle
  And user selects a type
  And user selects a date
  And user enters total price
  And user enters cost description
  And user clicks on save button
  Then title is changed to "Audi/A1/" - Odoo

 @wip
 Scenario: User should see Attachment(s) and Action buttons
  Given : user is already logged in and on main page
  When user clicks on more button
  And user clicks fleet button
  And user clicks Vehicle Costs button
  And user clicks create button
  And user sees the title New
  And user selects a vehicle
  And user selects a type
  And user selects a date
  And user enters total price
  And user enters cost description
  And user clicks on save button
  Then user sees Attachments and Action buttons









