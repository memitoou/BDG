# Proyecto de Pruebas API - ReqRes

## Descripción
Este proyecto es una suite de pruebas automatizadas para la API de [ReqRes](https://reqres.in/) usando las tecnologías:
- Java
- RestAssured
- Serenity BDD
- Screenplay
- Cucumber

## Requisitos
- JDK 17
- Gradle 8.4

## Instalación
1. Clonar el repositorio.
2. Navegar al directorio del proyecto.
3. Ejecutar `gradle clean test` para correr las pruebas.

## Estructura del Proyecto
- **features/**: Contiene los archivos .feature escritos en Gherkin.
- **steps/**: Contiene la implementación de los pasos en Cucumber.
- **tasks/**: Contiene las interacciones con la API siguiendo el patrón Screenplay.
- **runners/**: Contiene la clase TestRunner para ejecutar las pruebas.

## Ejecución
1. Ejecutar las pruebas con:
   ```bash
   gradle clean test

