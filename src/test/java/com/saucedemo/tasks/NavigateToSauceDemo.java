package com.saucedemo.tasks;

import com.saucedemo.utils.Environments;               // ✅ Clase utilitaria para leer serenity.properties
import net.serenitybdd.screenplay.Actor;              // Actor del patrón Screenplay
import net.serenitybdd.screenplay.Task;               // Interfaz de Task en Screenplay
import net.serenitybdd.screenplay.actions.Open;       // Acción para abrir una URL

/**
 * Clase: NavigateToSauceDemo
 * --------------------------
 * Task que abre la URL de SauceDemo leyendo el valor desde serenity.properties.
 *
 * Requiere que serenity.properties contenga:
 * webdriver.base.url=<a href="https://www.saucedemo.com">...</a>
 *
 * Ventajas:
 * - Centralizamos la lectura de propiedades en la clase utils Environments.
 * - No se "hardcodea" la URL en la Task.
 */
public class NavigateToSauceDemo implements Task {

    // Obtenemos la URL desde serenity.properties usando la clase utilitaria
    private static final String SAUCEDEMO_URL = Environments.getVariable("webdriver.base.url");

    // Método de fábrica para invocar esta Task desde los StepDefinitions
    public static NavigateToSauceDemo page() {
        return new NavigateToSauceDemo();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Abre el navegador en la URL configurada
        actor.attemptsTo(Open.url(SAUCEDEMO_URL));
    }
}
