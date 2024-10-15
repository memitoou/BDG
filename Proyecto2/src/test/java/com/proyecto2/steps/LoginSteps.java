package com.proyecto2.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.proyecto2.tasks.LoginTask;

public class LoginSteps {
    WebDriver driver;
    Actor user = Actor.named("user");

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Asegúrate de tener ChromeDriver instalado
        driver = new ChromeDriver();
        user.can(BrowseTheWeb.with(driver));
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        user.attemptsTo(LoginTask.withCredentials("standard_user", "secret_sauce"));
    }

    @Then("the user should see the products page")
    public void userShouldSeeProductsPage() {
        // Aquí puedes agregar una validación para comprobar que el usuario está en la página de productos
    }
}

