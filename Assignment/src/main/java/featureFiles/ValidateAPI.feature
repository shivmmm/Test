#FeatureDefination File

Feature: Validate API Responses and Status
Background:
Given Foreign Exchange Rates API is up and running

Scenario Outline:Get Status code  for "<endpoint>"
When Hit the API with end point as "<endpoint>"
Then API should return the status code as 200
Examples:
|endpoint|
|/latest|
|/2010-01-12|  

Scenario Outline: Get Base Value for "<endpoint>"
When Hit the API with end point as "<endpoint>"
Then Base Value should be "EUR"
Examples:
|endpoint|
|/latest|
|/2010-01-12| 

Scenario: Validate Error Message and status code when putting incorrect endpoint "latest?base=XXX"
When Hit the API with end point as "latest?base=XXX"
Then API should return the status code as 400
And Error message should displayed as "Base 'XXX' is not supported."


Scenario: Put future date and validate current date data should present
When Hit the API with end point as "/2021-05-12"
Then API should return the current date rates