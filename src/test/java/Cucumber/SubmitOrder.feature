  @tag
  Feature: Purchase the order from a Ecommerce Website
  I want to use this template for my feature file
  Background:
  Given I landed on the Ecommerce Page.
  @Regression
  Scenario Outline: Positive test of purchasing the order
    Given Logged in with username "<name>" and password "<password>"
    When  I add product "<productName>" to cart
    And   Checkout "<productName>" and submit the Order
    Then  "THANKYOU FOR THE ORDER." message is displayed on the confirmation page

    Examples: 
      |name  		 			|password |productName |
      |test@gmail.ABC |Admin@123|ZARA COAT 3 |
      
