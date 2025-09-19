package com.saucedemo.tasks;
// Paquete de tareas: aquí se definen las acciones de alto nivel que un Actor puede realizar.

/* ---------------------------------------------------------------------------
   Imports necesarios
--------------------------------------------------------------------------- */
// Page Object con los localizadores de la página de login

import com.saucedemo.interactions.LoginI;
import net.serenitybdd.screenplay.Actor;             // Representa al usuario/actor en las pruebas
import net.serenitybdd.screenplay.Task;              // Interfaz que define una Tarea en Screenplay


/**
 * Clase: Login
 * ------------
 * Representa la tarea (Task) de iniciar sesión en SauceDemo.

 * - Usa el patrón Screenplay: un Actor "intenta" realizar esta tarea.
 * - Puede ejecutarse con credenciales personalizadas o por defecto.
 * - Interactúa con los elementos definidos en LoginPage.
 */
public class Login implements Task {

    private final String username;  // Usuario a ingresar
    private final String password;  // Contraseña a ingresar

    // Constructor privado: obliga a usar los métodos de fábrica (withCredentials o withDefaultCredentials)
    private Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Método de fábrica para login con credenciales dinámicas (parametrizadas desde el escenario)
    public static Login withCredentials(String username, String password) {
        return new Login(username, password);
    }

    // Método de fábrica para login con credenciales estándar (predefinidas en SauceDemo)
    public static Login withDefaultCredentials() {
        return new Login("standard_user", "secret_sauce");
    }

    /**
     * Método performAs
     * ----------------
     * Implementa la lógica que ejecutará el Actor:
     * - Digita el username en el campo USERNAME_FIELD
     * - Digita el password en el campo PASSWORD_FIELD
     * - Hace clic en el botón de login
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                LoginI.with(username,password)
        );
    }
}
