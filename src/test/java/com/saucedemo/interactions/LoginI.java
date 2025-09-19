package com.saucedemo.interactions;

import com.saucedemo.pages.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

/**
 * Interaction: PerformLogin
 * -------------------------
 * Define las acciones atómicas para digitar usuario, contraseña y hacer clic.
 * Separa la lógica de interacción directa con el DOM.
 */
public class LoginI implements Interaction {

    private final String username;
    private final String password;

    public LoginI(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Método de fábrica para mayor legibilidad
    public static LoginI with(String username, String password) {
        return new LoginI(username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
