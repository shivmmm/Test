#Author: shivam Malhotra
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#FeatureDefination File


Feature: Validate API Responses and Status
Background:
Given Foreign Exchange Rates API is up and running

@smoke
Scenario Outline:Get Status code  for "<endpoint>"
When Hit the API with end point as "<endpoint>"
Then API should return the status code as 200
Examples:
|endpoint|
|/latest|
|/2010-01-12|  

Scenario Outline: Hit the API with endpoint "<endpoint>" and validate the base value
When Hit the API with end point as "<endpoint>"
Then Base Value should be "EUR"
Examples:
|endpoint|
|/latest|
|/2010-01-12| 

Scenario: Hit the API with incorrect endpoint "latest?base=XXX" and validate the message
When Hit the API with end point as "latest?base=XXX"
Then API should return the status code as 400
And Error message should displayed as "Base 'XXX' is not supported."


Scenario: Hit the API with future date and validate current date data should present
When Hit the API with end point as "/2021-05-12"
Then API should return the current date rates