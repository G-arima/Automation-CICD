@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Negative Test of validating the Error encountered while logging into Ecommerce website
    Given I landed on the Ecommerce Page.
    When  Logged in with username "<name>" and password "<password>"
    Then "Incorrect email password." message is displayed

    Examples: 
      | name           | password | 
      | test@gmail.XYZ | Admin@123|
      
