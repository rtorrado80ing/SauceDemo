package com.saucedemo.utils;
// Paquete de utilidades: aquí se definen helpers reutilizables para el proyecto.

/* ---------------------------------------------------------------------------
   Imports de Serenity/Thucydides para manejo de variables de entorno
--------------------------------------------------------------------------- */
import net.thucydides.model.environment.SystemEnvironmentVariables; // Clase que inicializa el contexto de variables
import net.thucydides.model.util.EnvironmentVariables;              // Interfaz para acceder a las propiedades de Serenity

/**
 * Clase: Environments
 * -------------------
 * Clase utilitaria para acceder a variables configuradas en Serenity.

 * ¿Para qué sirve?
 * - Centraliza la lectura de propiedades definidas en el archivo serenity.properties
 *   o pasadas como parámetros del sistema (-Dpropiedad=valor).
 * - Evita repetir código en múltiples clases (Tasks, Questions, StepDefinitions).
 */
public class Environments {

    // Objeto singleton que contiene todas las variables disponibles en el entorno Serenity
    static EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    /**
     * Método getVariable
     * ------------------
     * Retorna el valor de una propiedad definida en serenity.properties
     * o en las variables del sistema (-Dnombre=valor).
     */
    public static String getVariable(String nameEnv) {
        return environmentVariables.getProperty(nameEnv);
    }
}
