Feature: User API Tests

Scenario: List users and validate response contains at least one user
    Given the user API is accessible
    When I send a request to list users
    Then the response should contain at least one user

Scenario: Register a new user and validate the response
    Given the user API is accessible
    When I send a request to register a new user with name "John" and job "Developer"
    Then the response should have a status code of 201
    And the response should contain the name "John"
    And the response should contain the job "Developer"

Scenario: Attempt to register a user without providing required data
    Given the user API is accessible
    When I send a request to register a new user without name and job
    Then the response should contain an error message

Scenario: Update an existing user's information
    Given the user API is accessible
    When I send a request to update the user with ID 1 and name "John Doe" and job "Senior Developer"
    Then the response should have a status code of 200
    And the response should contain the updated name "John Doe"
    And the response should contain the updated job "Senior Developer"

Scenario: Delete a user and validate the operation was successful
    Given the user API is accessible
    When I send a request to delete the user with ID 1
    Then the response should have a status code of 204

