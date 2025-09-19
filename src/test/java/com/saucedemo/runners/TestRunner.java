package com.saucedemo.runners;
// Paquete donde se ubica el runner de ejecución de Cucumber + Serenity

import io.cucumber.junit.CucumberOptions;             // Anotación para configurar Cucumber (features, glue, reportes, tags, etc.)
import net.serenitybdd.cucumber.CucumberWithSerenity; // Runner especial de Serenity que envuelve Cucumber
import org.junit.runner.RunWith;                      // Anotación JUnit para definir el runner de la clase

/**
 * Clase TestRunner
 * ----------------
 * Esta clase sirve como punto de entrada para ejecutar los escenarios escritos en Gherkin
 * usando Cucumber + Serenity BDD.

 * - Se define como Runner de JUnit con @RunWith(CucumberWithSerenity.class)
 * - Configura ubicación de features, step definitions y plugins de reporte.
 * - Puede filtrar escenarios usando tags.
 */
@RunWith(CucumberWithSerenity.class) // Indica a JUnit que use Serenity como runner para Cucumber
@CucumberOptions(
        // Ruta donde se encuentran los archivos .feature
        features = "src/test/resources/features",

        // Paquete raíz donde están las clases con Step Definitions
        glue = "com.saucedemo.stepdefinitions",

        // Plugins de Cucumber (además de los reportes que genera Serenity automáticamente)
        // "pretty" → salida legible en consola
        // En target/rerunBack.txt tendrás un archivo con paths a los features + líneas donde fallaron.
        plugin = {"pretty", "rerun:target/rerunBack.txt"},

        // Tags para filtrar qué escenarios ejecutar.
        // Ejemplo: tags = "@smoke" ejecutaría solo escenarios con esa etiqueta.
        // Si está vacío, ejecuta todos los escenarios.
        tags = ""
)
public class TestRunner {
    // Clase vacía: no necesita métodos.
    // La ejecución se controla mediante las anotaciones @RunWith y @CucumberOptions.
}
