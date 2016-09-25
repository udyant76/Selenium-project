#Author: Udyant Kumar


Feature: Test User Action
Scenario: Login and Logout Success
	Given User is on Home Page
	When User Navigate to LogIn Page
	And User enters UserName and Password
	Then Message displayed Login Successfully
 
Scenario: Login Failure with Wrong Username
	When User enters Wrong UserName
	Then Message displayed Wrong Username

Scenario: Login Failure with Wrong Password
	When User enters Wrong Password
	Then Message displayed Wrong Password

Scenario: Browser closed
	Then Browser is Getting Closed
	
Scenario: Mouse Hover Over Image 1
	Given User is on Home Page
	When User Navigate to Hover Page
	And User hovers Image 1
	Then Message displayed User 1
	
Scenario: Mouse Hover Over Image 2
	When User hovers Image 2
	Then Message displayed User 2
	
Scenario: Browser closed
	Then Browser is Getting Closed
	
	
Scenario: Arrange Table in Ascending order
	Given User is on Home Page
	When User Navigate to Table Page
	And User Click Table First Time
	Then User Gets Table in Ascending Order
	
Scenario: Arrange Table in Descending order
	When User Click Table Second Time
	Then User Gets Table in Descending Order
	
Scenario: Browser closed
	Then Browser is Getting Closed