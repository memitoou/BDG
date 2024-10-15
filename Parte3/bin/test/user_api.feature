Feature: User API

    Scenario: List users
        Given the user API is accessible
        When I send a request to list users
        Then the response should contain at least one user

    Scenario: Register a new user
        Given the user API is accessible
        When I send a request to register a new user with name "John" and job "Developer"
        Then the response should have a status code of 201
        And the response should contain the name "John"
        And the response should contain the job "Developer"

    Scenario: Attempt to register a user without mandatory data
        Given the user API is accessible
        When I send a request to register a new user without name and job
        Then the response should have a status code of 400
        And the response should contain an error message

    Scenario: Update an existing user
        Given the user API is accessible
        When I send a request to update the user with ID 2 and name "Jane" and job "Manager"
        Then the response should have a status code of 200
        And the response should contain the updated name "Jane"
        And the response should contain the updated job "Manager"

    Scenario: Delete a user
        Given the user API is accessible
        When I send a request to delete the user with ID 2
        Then the response should have a status code of 204

   Scenario: Update existing user information
   	Given the user API is accessible
    	When I update the user with ID "2" with name "John Doe" and job "Developer"
    	Then the response should have status code 200
    	And the updated user's name should be "John Doe"
    	And the updated user's job should be "Developer"

   Scenario: Delete a user
    	Given the user API is accessible
    	When I delete the user with ID "2"
    	Then the response should have status code 204
    	And the user should no longer exist

