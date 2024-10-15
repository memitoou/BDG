Feature: User API

  Scenario: Retrieve user details
    Given the user API is accessible
    When I retrieve the user with ID 2
    Then I should see that the user ID is 2, email is "janet.weaver@reqres.in", first name is "Janet", and last name is "Weaver"

