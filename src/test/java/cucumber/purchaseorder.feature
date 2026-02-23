Feature: Purchase Order

  Background:
    Given I landed on ecommerce website

  Scenario Outline: Get product from e commerce app
    Given Login with username <name> and password <pass>
    When Select the product <prod> from the cart
    Then "THANKYOU FOR THE ORDER." should be displayed

    Examples:
|name            |pass  |prod|
|akshaysabe@gmail.com|Bullet@1111|ZARA COAT 3|
