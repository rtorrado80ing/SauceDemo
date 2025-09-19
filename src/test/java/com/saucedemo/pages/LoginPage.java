package com.saucedemo.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERNAME_FIELD = Target.the("username field")
            .located(By.id("user-name"));

    public static final Target PASSWORD_FIELD = Target.the("password field")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.id("login-button"));

    public static final Target ERROR_MESSAGE = Target.the("error message")
            .located(By.cssSelector("[data-test='error']"));

    public static final Target LOGO = Target.the("SauceDemo logo")
            .located(By.className("login_logo"));
}
