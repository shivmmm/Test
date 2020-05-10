#FeatureDefination File
@Acceptance
Feature: Validate API Responses and Status
Background:
Given Foreign Exchange Rates API is up and running
Scenario Outline:Get Status code and Base Value for "<endpoint>"

When Hit the API with end point as "<endpoint>"
Then API should return the status code as 200

#And Validate the JsonReponse

Examples:
|endpoint|
|/latest|
|/2010-01-12|  

Scenario: Validate base Value
When Hit the API with end point as "<endpoint>"
Then Validate base Value "EUR"
And Validate Date

