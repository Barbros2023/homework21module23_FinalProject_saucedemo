@api
Feature: User API operations

  Scenario: Get list of users
    Given I send a GET request to "/user"
    Then the response status code should be 200
    And the response should contain a list of users

  Scenario: Get user by ID
    When I send a GET request to "/user/60d0fe4f5311236168a109d9"
    Then the response status code should be 200
    And the response should contain the ID "60d0fe4f5311236168a109d9"
