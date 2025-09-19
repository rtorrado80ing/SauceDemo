package com.saucedemo.questions;
// Paquete de preguntas: aquí se definen verificaciones (Questions) que responden
// con información del estado actual de la aplicación.

/* ---------------------------------------------------------------------------
   Imports
--------------------------------------------------------------------------- */
import com.saucedemo.pages.ProductsPage;         // Page Object con los localizadores de la página de productos
import net.serenitybdd.screenplay.Actor;         // Actor del patrón Screenplay
import net.serenitybdd.screenplay.Question;      // Interfaz que define una "Pregunta" (Question) en Screenplay
import net.serenitybdd.screenplay.questions.Visibility; // Question lista de Serenity: evalúa visibilidad de elementos

/**
 * Clase: TheLoginStatus
 * ---------------------
 * Question que valida si el login fue exitoso en la aplicación SauceDemo.
 *
 * - Una Question devuelve un valor (en este caso Boolean).
 * - Aquí la validación consiste en verificar si el contenedor de inventario
 *   está visible después de hacer login.
 * - Se utiliza en los StepDefinitions para escribir aserciones legibles.
 *
 * Ejemplo de uso:
 *   user.should(seeThat(TheLoginStatus.isSuccessful(), is(true)));
 */
public class TheLoginStatus implements Question<Boolean> {

    /**
     * Método de fábrica (factory method)
     * ----------------------------------
     * Crea una instancia de la Question.
     * Su nombre hace que el código en los Steps sea más expresivo.
     */
    public static TheLoginStatus isSuccessful() {
        return new TheLoginStatus();
    }

    /**
     * Método answeredBy
     * -----------------
     * Define la lógica de la pregunta:
     * - Se consulta si el contenedor de inventario está visible.
     * - Devuelve true si lo está, false en caso contrario.
     */
    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ProductsPage.INVENTORY_CONTAINER).answeredBy(actor);
    }
}
