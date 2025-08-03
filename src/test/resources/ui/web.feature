@web
Feature: Complete purchase flow on Saucedemo

  Scenario: User logs in and completes a purchase
    Given I open the SauceDemo login page
    When I login with username "standard_user" and password "secret_sauce"
    And I add the first item to the cart
    And I go to the cart page
    And I proceed to checkout
    And I enter checkout information with first name "John", last name "Doe", and postal code "12345"
    And I finish the checkout
    Then I should see the confirmation message "Thank you for your order!"
