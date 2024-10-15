Feature: Protected Resource Access

Scenario: Access protected resource with valid token
    Given I register a user with the following data
        | email             | password |
        | eve.holt@reqres.in | city123  |
    And I have a valid token
    When I send a request to a protected resource
    Then I should receive a successful response

