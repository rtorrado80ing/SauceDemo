package com.saucedemo.stepdefinitions;
// Paquete donde se encuentran las definiciones de pasos (Step Definitions)

/* ---------------------------------------------------------------------------
   Imports de páginas, tareas y preguntas específicas de tu proyecto
--------------------------------------------------------------------------- */
import com.saucedemo.pages.ProductsPage;              // Page Object con localizadores de la página de productos
import com.saucedemo.questions.TheCartItemCount;      // Question que obtiene la cantidad de ítems en el carrito
import com.saucedemo.questions.TheNumberOfProducts;   // Question que cuenta cuántos productos hay disponibles
import com.saucedemo.tasks.AddProductToCart;          // Task para agregar un producto al carrito
import com.saucedemo.tasks.Login;                     // Task para iniciar sesión
import com.saucedemo.tasks.NavigateToSauceDemo;       // Task para navegar a la página inicial

/* ---------------------------------------------------------------------------
   Imports de Cucumber en español (Dado, Cuando, Entonces, Y)
--------------------------------------------------------------------------- */
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

/* ---------------------------------------------------------------------------
   Imports de Serenity Screenplay
--------------------------------------------------------------------------- */
import net.serenitybdd.annotations.Managed;                  // Manejo automático del WebDriver
import net.serenitybdd.screenplay.Actor;                     // Actor del patrón Screenplay
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;    // Habilidad de navegar en la web
import net.serenitybdd.screenplay.questions.Visibility;      // Question: verificar visibilidad de un elemento

/* ---------------------------------------------------------------------------
   Imports de validaciones (assertions)
--------------------------------------------------------------------------- */
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat; // Para expresiones de verificación
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.WebDriver; // Driver de Selenium que usa el Actor

/**
 * Clase: ShoppingStepDefinitions
 * ------------------------------
 * Contiene la implementación de los pasos definidos en los .feature de Cucumber
 * para validar el flujo de compra en SauceDemo:
 * - Navegar a la app
 * - Iniciar sesión
 * - Agregar productos al carrito
 * - Verificar el contenido del carrito y el inventario
 */
public class ShoppingStepDefinitions {

    @Managed
    WebDriver driver;
    // Serenity administra automáticamente el ciclo de vida del WebDriver.
    // Se inyecta aquí para que el actor pueda usarlo.

    private final Actor user = Actor.named("User");
    // Actor que representa al usuario durante la ejecución de las pruebas.

    // -----------------------------
    // Escenario: el usuario navega a SauceDemo
    // -----------------------------
    @Dado("que el usuario está en la página de inicio de sesión de SauceDemo")
    public void queElUsuarioEstaEnLaPaginaDeInicioDeSesion() {
        user.can(BrowseTheWeb.with(driver));        // El actor obtiene la habilidad de navegar con WebDriver
        user.attemptsTo(NavigateToSauceDemo.page()); // Task para abrir la página de SauceDemo
    }

    // -----------------------------
    // Escenario: inicio de sesión estándar
    // -----------------------------
    @Y("el usuario inicia sesión con credenciales estándar")
    public void elUsuarioIniciaSesionConCredencialesEstandar() {
        user.attemptsTo(Login.withDefaultCredentials()); // Task para login con usuario y password por defecto
    }

    // -----------------------------
    // Escenario: agregar producto al carrito
    // -----------------------------
    @Cuando("el usuario agrega el primer producto al carrito")
    public void theUserAddsTheFirstProductToTheCart() {
        user.attemptsTo(AddProductToCart.firstProduct()); // Task que agrega el primer producto listado
    }

    @Entonces("el carrito de compras debería mostrar {int} artículo")
    public void theShoppingCartShouldShowItem(int expectedCount) {
        // Verifica que el número mostrado en el carrito sea igual al esperado
        user.should(seeThat(TheCartItemCount.displayed(),
                equalTo(String.valueOf(expectedCount))));
    }

    @Y("la insignia del carrito debería ser visible")
    public void theCartBadgeShouldBeVisible() {
        // Verifica que la insignia del carrito (badge) esté visible en la UI
        user.should(seeThat(Visibility.of(ProductsPage.SHOPPING_CART_BADGE), is(true)));
    }

    // -----------------------------
    // Escenario: ver inventario de productos
    // -----------------------------
    @Entonces("el usuario debería ver el inventario de productos")
    public void theUserShouldSeeTheProductsInventory() {
        // Verifica que el contenedor de inventario de productos esté visible
        user.should(seeThat(Visibility.of(ProductsPage.INVENTORY_CONTAINER), is(true)));
    }

    @Y("múltiples productos deberían estar disponibles para compra")
    public void multipleProductsShouldBeAvailableForPurchase() {
        // Verifica que haya más de 0 productos disponibles en el inventario
        user.should(seeThat(TheNumberOfProducts.displayed(), greaterThan(0)));
    }
}
