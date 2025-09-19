package com.saucedemo.questions;
// Paquete de preguntas (Questions): encapsulan verificaciones sobre el estado actual de la UI.

/* ---------------------------------------------------------------------------
   Imports
--------------------------------------------------------------------------- */
import com.saucedemo.pages.ProductsPage;    // Page Object con los localizadores de la página de productos
import net.serenitybdd.screenplay.Actor;    // Actor del patrón Screenplay
import net.serenitybdd.screenplay.Question; // Interfaz que define una "Pregunta" en Screenplay

/**
 * Clase: TheNumberOfProducts
 * --------------------------
 * Question que devuelve el número de productos visibles en la página de inventario.
 *
 * - Retorna un Integer (cantidad total de elementos en la lista de productos).
 * - Útil para validar que el inventario no esté vacío o que tenga la cantidad esperada.
 *
 * Ejemplo de uso:
 * ---------------
 * user.should(seeThat(TheNumberOfProducts.displayed(), greaterThan(0)));
 * user.should(seeThat(TheNumberOfProducts.displayed(), equalTo(6)));
 */
public class TheNumberOfProducts implements Question<Integer> {

    /**
     * Método de fábrica (factory method)
     * ----------------------------------
     * Crea una instancia de la Question de forma expresiva.
     * Ejemplo: TheNumberOfProducts.displayed()
     */
    public static TheNumberOfProducts displayed() {
        return new TheNumberOfProducts();
    }

    /**
     * Método answeredBy
     * -----------------
     * Lógica principal de la Question:
     * - Resuelve el localizador `PRODUCT_ITEMS` definido en ProductsPage.
     * - Obtiene todos los elementos que coinciden en la página.
     * - Devuelve el tamaño de esa lista (cantidad de productos).
     *
     * @param actor Actor que ejecuta la pregunta.
     * @return Número total de productos visibles en la página.
     */
    @Override
    public Integer answeredBy(Actor actor) {
        return ProductsPage.PRODUCT_ITEMS.resolveAllFor(actor).size();
    }
}
