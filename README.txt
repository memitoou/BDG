# Proyecto de Automatización de Pruebas API

Este proyecto tiene como objetivo automatizar un conjunto de llamadas a la API del sitio web [ReqRes](https://reqres.in/) utilizando **Java**, **RestAssured**, **Serenity BDD**, el patrón **Screenplay**, y **Cucumber**. Este README documenta cada paso del proceso, proporcionando detalles sobre la configuración, los escenarios de prueba y cómo ejecutar las pruebas.

## Tabla de Contenidos

1. [Objetivo](#objetivo)
2. [Requisitos Previos](#requisitos-previos)
3. [Instalación](#instalación)
4. [Estructura del Proyecto](#estructura-del-proyecto)
5. [Detalles del Proyecto](#detalles-del-proyecto)
   - [1. Mapeo de Endpoints en Postman](#1-mapeo-de-endpoints-en-postman)
   - [2. Configuración del Proyecto](#2-configuración-del-proyecto)
   - [3. Escenarios de Prueba en Gherkin con Cucumber](#3-escenarios-de-prueba-en-gherkin-con-cucumber)
   - [4. Implementación de Escenarios con Enfoque Screenplay](#4-implementación-de-escenarios-con-enfoque-screenplay)
   - [5. Informes](#5-informes)
6. [Ejecución de Pruebas](#ejecución-de-pruebas)


## Objetivo

Automatizar un conjunto de llamadas a la API del sitio web [https://reqres.in/](https://reqres.in/) utilizando **RestAssured**, **Java**, **Serenity BDD**, el patrón **Screenplay** con enfoque en **Cucumber** y **Postman**.

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- **Java 11 o superior**: Verifica la instalación ejecutando:

  ```bash
  java -version

## Instalacion

Gradle: Para gestionar dependencias y ejecutar tareas. 
Postman: Utilizado para mapear y probar los endpoints de la API.
Gradle descargará automáticamente todas las dependencias necesarias al ejecutar las pruebas.

## Estructura del Proyecto

Parte2
├── build
│   ├── classes
│   │   └── java
│   │       └── test
│   │           └── com
│   │               ├── bdg
│   │               │   ├── runners
│   │               │   │   └── CucumberTestSuite.class
│   │               │   ├── stepdefinitions
│   │               │   │   └── ApiStepDefinitions.class
│   │               │   ├── steps
│   │               │   │   └── UserApiSteps.class
│   │               │   └── tests
│   │               │       └── UsuarioTests.class
│   │               └── tu_paquete
│   │                   └── ApiSteps.class
│   ├── generated
│   │   └── sources
│   │       ├── annotationProcessor
│   │       │   └── java
│   │       │       └── test
│   │       └── headers
│   │           └── java
│   │               └── test
│   ├── libs
│   │   └── Parte2.jar
│   ├── reports
│   │   └── tests
│   │       └── test
│   │           ├── classes
│   │           │   └── com.bdg.tests.UsuarioTests.html
│   │           ├── css
│   │           │   ├── base-style.css
│   │           │   └── style.css
│   │           ├── index.html
│   │           ├── js
│   │           │   └── report.js
│   │           └── packages
│   │               └── com.bdg.tests.html
│   ├── resources
│   │   └── test
│   │       ├── cucumber.properties
│   │       └── features
│   │           ├── api_tests.feature
│   │           ├── example.feature
│   │           └── user_api.feature
│   ├── test-results
│   │   └── test
│   │       ├── binary
│   │       │   ├── output.bin
│   │       │   ├── output.bin.idx
│   │       │   └── results.bin
│   │       └── TEST-com.bdg.tests.UsuarioTests.xml
│   └── tmp
│       ├── compileTestJava
│       │   └── previous-compilation-data.bin
│       ├── jar
│       │   └── MANIFEST.MF
│       └── test
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── history
├── postman
│   └── BDG_Collection.json
├── settings.gradle
├── src
│   └── test
│       ├── java
│       │   └── com
│       │       ├── bdg
│       │       │   ├── runners
│       │       │   │   └── CucumberTestSuite.java
│       │       │   ├── stepdefinitions
│       │       │   │   └── ApiStepDefinitions.java
│       │       │   ├── steps
│       │       │   │   └── UserApiSteps.java
│       │       │   └── tests
│       │       │       └── UsuarioTests.java
│       │       └── paquete
│       │           └── ApiSteps.java
│       └── resources
│           ├── cucumber.properties
│           └── features
│               ├── api_tests.feature
│               ├── example.feature
│               └── user_api.feature
└── target
    └── site
        └── serenity

Parte3
├── build
│   ├── classes
│   │   └── java
│   │       └── test
│   │           └── com
│   │               └── bdg
│   │                   ├── steps
│   │                   │   └── UserApiSteps.class
│   │                   └── tests
│   │                       └── ApiTests.class
│   ├── generated
│   │   └── sources
│   │       ├── annotationProcessor
│   │       │   └── java
│   │       │       └── test
│   │       └── headers
│   │           └── java
│   │               └── test
│   ├── libs
│   │   └── Parte3.jar
│   ├── reports
│   │   └── tests
│   │       └── test
│   │           ├── css
│   │           │   ├── base-style.css
│   │           │   └── style.css
│   │           ├── index.html
│   │           └── js
│   │               └── report.js
│   ├── resources
│   │   └── test
│   │       └── user_api.feature
│   ├── test-results
│   │   └── test
│   │       └── binary
│   │           ├── output.bin
│   │           ├── output.bin.idx
│   │           └── results.bin
│   └── tmp
│       ├── compileTestJava
│       │   └── previous-compilation-data.bin
│       ├── jar
│       │   └── MANIFEST.MF
│       └── test
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    └── test
        ├── java
        │   └── com
        │       └── bdg
        │           ├── steps
        │           │   └── UserApiSteps.java
        │           └── tests
        │               └── ApiTests.java
        └── resources
            └── user_api.feature


Parte4
├── build.gradle          # Archivo de configuración de Gradle
├── settings.gradle       # Configuración de Gradle
└── src
    ├── main
    └── test
        ├── java
        │   └── com
        │       └── bdg
        │           ├── interactions     # Clases de interacción con la API
        │           │   ├── RestInteraction.java
        │           │   └── UserApiInteraction.java
        │           ├── models           # Modelos de datos
        │           │   └── User.java
        │           ├── steps            # Clases de pasos de Cucumber
        │           │   └── UserApiSteps.java
        │           └── UserApiTest.java # Clase principal de prueba
        └── resources
            └── features
                └── UserApi.feature      # Archivo de características de Cucumber
    
## Detalles del Proyecto
1. Mapeo de Endpoints en Postman
Objetivo: Probar los endpoints del sitio https://reqres.in/ utilizando Postman.
Acciones:
Crea una colección en Postman que incluya los siguientes requests:
Listar usuarios
Registrar usuario
Actualizar usuario
Eliminar usuario
Exporta y guarda la colección para entregarla junto con los demás entregables del reto.
2. Configuración del Proyecto
Objetivo: Crear un nuevo proyecto en Java utilizando Gradle y configurar las dependencias necesarias.
Acciones:
Configura build.gradle para incluir las dependencias de RestAssured, Cucumber y Serenity BDD.
3. Escenarios de Prueba en Gherkin con Cucumber
Objetivo: Escribir escenarios de prueba en formato Gherkin para los casos descritos.
Acciones: En el archivo UserApi.feature, estructura los escenarios utilizando las etiquetas Given, When y Then para cada caso:
Listar usuarios y validar que la respuesta contenga al menos un usuario.
Registrar un nuevo usuario y validar que la respuesta sea la esperada.
Intentar registrar un usuario sin proporcionar datos obligatorios y validar el error.
Actualizar la información de un usuario existente y validar que la actualización sea correcta.
Eliminar un usuario y validar que la operación haya sido exitosa.
4. Implementación de Escenarios con Enfoque Screenplay
Objetivo: Implementar el patrón Screenplay y utilizar el método seeThat para realizar aserciones en el paso Then.
Acciones:
Crear una clase de interacción que implemente RestInteraction.
Validar que el consumo de los endpoints sea exitoso y verificar el estado del código HTTP.
Guardar la respuesta del endpoint en un modelo y validar el contenido del JSON usando JsonPath.
5. Informes
Objetivo: Configurar Serenity BDD para generar informes después de la ejecución de las pruebas.
Acciones:
Asegúrate de que Serenity esté configurado en el archivo build.gradle para generar informes detallados sobre las llamadas realizadas y sus respuestas.

## Ejecución de Pruebas
Para ejecutar las pruebas, sigue estos pasos:
    Abre una terminal en el directorio del proyecto.
    Ejecuta el siguiente comando:
        ./gradlew clean test
