
Feature: Supplier return creation
 
Scenario: Go to purchase portal
 
  Given User is on Home Page
	When  User enters Function
	Then User able to go to purchase portal
 
Scenario: Create supplier return
	When User click on supplier returns and enters details
  Then Supplier return should be created