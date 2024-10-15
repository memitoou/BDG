Feature: API Tests for ReqRes

Scenario: List Users
    Given I set the base URL to "https://reqres.in/api"
    When I send a GET request to "/users?page=1"
    Then the response status code should be 200

Scenario: Register User
    Given I set the base URL to "https://reqres.in/api"
    When I send a POST request to "/register" with the following data
        | email             | password |
        | eve.holt@reqres.in | city123  |
    Then the response status code should be 200

Scenario: Update User
    Given I set the base URL to "https://reqres.in/api"
    When I send a PUT request to "/users/2" with the following data
        | name     | job       |
        | Michael  | Engineer  |
    Then the response status code should be 200

Scenario: Delete User
    Given I set the base URL to "https://reqres.in/api"
    When I send a DELETE request to "/users/2"
    Then the response status code should be 204

