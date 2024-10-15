Feature: Gestión de Usuarios

  Scenario: Listar todos los usuarios
    Given que la API de usuarios está en ejecución
    When se envía una solicitud GET a la API de usuarios
    Then la respuesta debe tener un código de estado 200
    And se deben retornar los usuarios

  Scenario: Registrar un nuevo usuario
    Given que la API de usuarios está en ejecución
    When se envía una solicitud POST a la API de usuarios con los siguientes datos:
      | nombre    | email              |
      | Juan Pérez| juan@example.com   |
    Then la respuesta debe tener un código de estado 201
    And el usuario debe ser creado con los siguientes datos:
      | nombre    | email              |
      | Juan Pérez| juan@example.com   |

  Scenario: Actualizar un usuario existente
    Given que la API de usuarios está en ejecución
    And un usuario con ID 1 existe
    When se envía una solicitud PUT a la API de usuarios con ID 1 y los siguientes datos:
      | nombre    | email              |
      | Juan Pérez| juan@nuevoemail.com|
    Then la respuesta debe tener un código de estado 200
    And el usuario debe ser actualizado con los siguientes datos:
      | nombre    | email              |
      | Juan Pérez| juan@nuevoemail.com|

  Scenario: Eliminar un usuario existente
    Given que la API de usuarios está en ejecución
    And un usuario con ID 1 existe
    When se envía una solicitud DELETE a la API de usuarios con ID 1
    Then la respuesta debe tener un código de estado 204
    And el usuario con ID 1 no debe existir en la base de datos

