package com.saucedemo.questions;
// Paquete de preguntas (Questions): encapsulan verificaciones sobre el estado de la UI.

/* ---------------------------------------------------------------------------
   Imports
--------------------------------------------------------------------------- */
import com.saucedemo.pages.ProductsPage;    // Page Object con localizadores de la página de productos
import net.serenitybdd.screenplay.Actor;    // Actor del patrón Screenplay
import net.serenitybdd.screenplay.Question; // Interfaz que define una "Pregunta" en Screenplay
import net.serenitybdd.screenplay.questions.Text; // Question lista que obtiene texto de un elemento

/**
 * Clase: TheCartItemCount
 * -----------------------
 * Question que obtiene el número de artículos mostrado en la insignia del carrito.
 *
 * - Devuelve un String (el texto que aparece en la badge del carrito).
 * - Sirve para validar si el carrito contiene la cantidad esperada de productos.
 *
 * Ejemplo de uso:
 * ---------------
 * user.should(seeThat(TheCartItemCount.displayed(), equalTo("1")));
 */
public class TheCartItemCount implements Question<String> {

    /**
     * Método de fábrica (factory method)
     * ----------------------------------
     * Permite instanciar la Question de forma más expresiva.
     * Ejemplo: TheCartItemCount.displayed()
     */
    public static TheCartItemCount displayed() {
        return new TheCartItemCount();
    }

    /**
     * Método answeredBy
     * -----------------
     * Define la lógica de la pregunta:
     * - Obtiene el texto de la insignia (badge) del carrito de compras.
     * - Retorna ese valor como String (ej. "1", "2").
     *
     * @param actor Actor que está interactuando con la aplicación.
     * @return Texto de la insignia del carrito.
     */
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ProductsPage.SHOPPING_CART_BADGE).answeredBy(actor);
    }
}
