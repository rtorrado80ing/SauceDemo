package com.saucedemo.stepdefinitions;
// Paquete donde se encuentran las definiciones de pasos (Step Definitions)

/* ---------------------------------------------------------------------------
   Imports de páginas, tareas y preguntas específicas de tu proyecto
--------------------------------------------------------------------------- */
import com.saucedemo.pages.LoginPage;             // Page Object con localizadores de la página de login
import com.saucedemo.pages.ProductsPage;          // Page Object con localizadores de la página de productos
import com.saucedemo.questions.TheLoginStatus;    // Question que válida si el login fue exitoso
import com.saucedemo.tasks.NavigateToSauceDemo;   // Task para navegar a la página de SauceDemo
import com.saucedemo.tasks.Login;                 // Task para realizar login con credenciales

/* ---------------------------------------------------------------------------
   Imports de Cucumber (anotaciones Gherkin)
--------------------------------------------------------------------------- */
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/* ---------------------------------------------------------------------------
   Imports de Serenity Screenplay
--------------------------------------------------------------------------- */
import net.serenitybdd.annotations.Managed;                  // Manejo automático del WebDriver
import net.serenitybdd.screenplay.Actor;                     // Actor del patrón Screenplay
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;    // Habilidad de navegar en la web
import net.serenitybdd.screenplay.actions.Click;             // Acción de hacer clic
import net.serenitybdd.screenplay.actions.Enter;             // Acción de digitar texto
import net.serenitybdd.screenplay.questions.Text;            // Question: obtener texto
import net.serenitybdd.screenplay.questions.Visibility;      // Question: verificar visibilidad

/* ---------------------------------------------------------------------------
   Imports de validaciones (assertions)
--------------------------------------------------------------------------- */
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat; // Para expresiones de verificación
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.WebDriver; // Driver de Selenium que usa el Actor

/**
 * Clase: LoginStepDefinitions
 * ---------------------------
 * Contiene la implementación de los pasos definidos en los feature de Cucumber
 * para validar el flujo de login en SauceDemo.

 * - Usa el patrón Screenplay (Actor → Tasks, Actions, Questions).
 * - Define la relación entre escenarios en Gherkin y el código ejecutable.
 * - Maneja casos de login exitoso y fallido.
 */
public class LoginStepDefinitions {

    @Managed
    WebDriver driver;
    // Serenity administra automáticamente el ciclo de vida del WebDriver.
    // Se inyecta aquí para que el actor pueda usarlo.

    private final Actor user = Actor.named("User");
    // Definimos un Actor que representará al usuario en las pruebas.

    // -----------------------------
    // Escenario: usuario navega a la página de login
    // -----------------------------
    @Given("the user is on the SauceDemo login page")
    public void theUserIsOnTheSauceDemoLoginPage() {
        user.can(BrowseTheWeb.with(driver));           // Actor obtiene la habilidad de navegar en web
        user.attemptsTo(NavigateToSauceDemo.page());   // Ejecuta la Task de navegación
    }

    // -----------------------------
    // Escenario: login con credenciales estándar
    // -----------------------------
    @When("the user logs in with standard credentials")
    public void theUserLogsInWithStandardCredentials() {
        user.attemptsTo(Login.withDefaultCredentials()); // Task: login con usuario/password predefinidos
    }

    // -----------------------------
    // Escenario: login con credenciales parametrizadas
    // -----------------------------
    @When("the user attempts to login with username {string} and password {string}")
    public void theUserAttemptsToLoginWithUsernameAndPassword(String username, String password) {
        user.attemptsTo(Login.withCredentials(username,password));
    }

    // -----------------------------
    // Escenario: login exitoso
    // -----------------------------
    @Then("the user should be redirected to the products page")
    public void theUserShouldBeRedirectedToTheProductsPage() {
        user.should(seeThat(TheLoginStatus.isSuccessful(), is(true))); // Verifica login exitoso
    }

    @And("the products page should display the inventory")
    public void theProductsPageShouldDisplayTheInventory() {
        user.should(seeThat(Visibility.of(ProductsPage.INVENTORY_CONTAINER), is(true))); // Inventory visible
        user.should(seeThat(Text.of(ProductsPage.PAGE_TITLE), equalTo("Products")));     // Título = "Products"
    }

    // -----------------------------
    // Escenario: login fallido
    // -----------------------------
    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        user.should(seeThat(Visibility.of(LoginPage.ERROR_MESSAGE), is(true))); // Mensaje de error visible
    }

    @And("the user should remain on the login page")
    public void theUserShouldRemainOnTheLoginPage() {
        user.should(seeThat(Visibility.of(LoginPage.LOGO), is(true))); // Logo visible → sigue en login
    }
}
