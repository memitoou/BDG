Feature: Probar la API de ReqRes

Scenario: Listar usuarios y validar que la respuesta contenga al menos un usuario
  Given I list users from the API
  When I fetch the user list
  Then I should see at least one user in the list

Scenario: Registrar un nuevo usuario y validar la respuesta
  Given I create a new user with name "John" and job "Developer"
  When I send the create user request
  Then I should see the created user with correct information

Scenario: Registrar un usuario sin datos y validar el error
  Given I attempt to create a user without providing mandatory data
  When I send the request
  Then I should see a validation error message

Scenario: Actualizar un usuario existente
  Given I update an existing user with ID 2 to have job "Manager"
  When I send the update user request
  Then I should see the updated user with correct job title

Scenario: Eliminar un usuario y validar el resultado
  Given I delete the user with ID 2
  When I send the delete request
  Then I should see a success response

