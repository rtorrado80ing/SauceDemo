package com.saucedemo.tasks;
// Paquete de tareas: aquí se definen las acciones que un Actor puede ejecutar en la aplicación.

/* ---------------------------------------------------------------------------
   Imports
--------------------------------------------------------------------------- */
import com.saucedemo.pages.ProductsPage;       // Page Object con los localizadores de la página de productos
import net.serenitybdd.screenplay.Actor;       // Representa al usuario/actor en el patrón Screenplay
import net.serenitybdd.screenplay.Task;        // Interfaz que define una Tarea en Screenplay
import net.serenitybdd.screenplay.actions.Click; // Acción Screenplay para hacer clic sobre un Target

/**
 * Clase: AddProductToCart
 * -----------------------
 * Representa la Tarea (Task) de agregar un producto al carrito de compras
 * en la aplicación SauceDemo.
 *
 * - Usa el patrón Screenplay: un Actor "intenta" realizar esta tarea.
 * - Interactúa con el botón "Add to Cart" definido en la clase ProductsPage.
 */
public class AddProductToCart implements Task {

    /**
     * Método de fábrica (factory method)
     * ----------------------------------
     * Crea una instancia de la tarea para agregar el primer producto al carrito.
     *
     * Ejemplo de uso en un StepDefinition:
     *   user.attemptsTo(AddProductToCart.firstProduct());
     */
    public static AddProductToCart firstProduct() {
        return new AddProductToCart();
    }

    /**
     * Método performAs
     * ----------------
     * Define las acciones que ejecutará el Actor:
     * - Localiza el botón del primer producto en la página de productos.
     * - Hace clic en ese botón para agregarlo al carrito.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPage.FIRST_ADD_TO_CART_BUTTON) // Acción: clic en el botón "Add to Cart"
        );
    }
}
