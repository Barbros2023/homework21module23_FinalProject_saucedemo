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

  Scenario: Get user by invalid ID format
    When I send a GET request to "/user/12345"
    Then the response status code should be 400

  Scenario: Get user by non-existent valid ID
    When I send a GET request to "/user/ffffffffffffffffffffffff"
    Then the response status code should be 404

  Scenario: Get list of users with limit 0
    When I send a GET request to "/user?limit=0"
    Then the response status code should be 200
    And the response should contain an empty data list
