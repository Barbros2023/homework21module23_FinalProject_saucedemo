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

  Scenario: User attempts to login with invalid credentials
    Given I open the SauceDemo login page
    When I login with username "invalid_user" and password "wrong_password"
    Then I should see an error message displayed

  Scenario: User attempts to login with empty credentials
    Given I open the SauceDemo login page
    When the user logs in with empty username and password
    Then I should see an error message displayed

  Scenario: Cart badge increases when adding item
    Given I open the SauceDemo login page
    When I login with username "standard_user" and password "secret_sauce"
    And I add the first item to the cart
    Then the cart badge should show "1"

  Scenario: Logout from the side menu
    Given I open the SauceDemo login page
    When I login with username "standard_user" and password "secret_sauce"
    And I log out from the side menu
    Then I should be redirected to the login page
