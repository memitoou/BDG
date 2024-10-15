Feature: Saucedemo Test Scenarios

  Scenario: Login with valid user
    Given the user is on the login page
    When the user logs in with valid credentials
    Then the user should see the products page

  Scenario: Login with invalid user
    Given the user is on the login page
    When the user logs in with invalid credentials
    Then an error message should be displayed

  Scenario: Add a product to the cart
    Given the user is logged in
    When the user adds a product to the cart
    Then the product should be in the cart

  Scenario: Complete purchase with one product
    Given the user has one product in the cart
    When the user completes the purchase
    Then the order confirmation page should be displayed

  Scenario: Add multiple products, remove one, and complete purchase
    Given the user is logged in
    When the user adds multiple products to the cart
    And the user removes one product
    And the user completes the purchase
    Then the order confirmation page should be displayed

