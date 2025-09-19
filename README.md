# SauceDemo Test Automation Project

Este proyecto implementa automatización de pruebas para el sitio web [SauceDemo](https://www.saucedemo.com) utilizando el patrón Screenplay con Serenity BDD, Cucumber y Selenium WebDriver.

## 🛠️ Tecnologías Utilizadas

- **Java 11+**: Lenguaje de programación principal
- **Gradle**: Gestor de dependencias y construcción
- **Serenity BDD**: Framework de automatización y reportes
- **Cucumber**: Herramienta BDD para escribir escenarios en lenguaje natural
- **Selenium WebDriver**: Automatización de navegadores web
- **Screenplay Pattern**: Patrón de diseño para pruebas más mantenibles

## 📁 Estructura del Proyecto

```
src/test/
├── java/com/saucedemo/
│   ├── pages/              # Elementos de página (Page Objects)
│   │   ├── LoginPage.java
│   │   └── ProductsPage.java
│   ├── tasks/              # Tareas de alto nivel (Screenplay Tasks)
│   │   ├── NavigateToSauceDemo.java
│   │   ├── Login.java
│   │   └── AddProductToCart.java
│   ├── questions/          # Consultas sobre el estado (Screenplay Questions)
│   │   ├── TheLoginStatus.java
│   │   └── TheCartItemCount.java
│   ├── stepdefinitions/    # Definiciones de pasos de Cucumber
│   │   ├── LoginStepDefinitions.java
│   │   └── ShoppingStepDefinitions.java
│   └── runners/            # Ejecutor de pruebas
│       └── TestRunner.java
└── resources/
    ├── features/           # Archivos de características (Gherkin)
    │   ├── login.feature
    │   └── shopping.feature
    └── serenity.properties # Configuración de Serenity BDD
```

## ⚙️ Configuración

### Credenciales por Defecto
- **URL**: https://www.saucedemo.com
- **Usuario**: standard_user
- **Contraseña**: secret_sauce

Estas credenciales están configuradas en el archivo `serenity.properties` y se pueden modificar según sea necesario.

### Configuración del Navegador
- **Navegador por defecto**: Chrome
- **Gestión automática de drivers**: Habilitada via WebDriverManager
- **Screenshots**: Solo en caso de fallos

## 🚀 Ejecución de Pruebas

### Ejecutar todas las pruebas
```bash
./gradlew test
```

### Ejecutar solo pruebas con tag @smoke
```bash
./gradlew test -Dcucumber.filter.tags="@smoke"
```

### Ejecutar pruebas de login
```bash
./gradlew test -Dcucumber.filter.tags="@login"
```

### Ejecutar pruebas de shopping
```bash
./gradlew test -Dcucumber.filter.tags="@shopping"
```

## 📊 Reportes

Después de ejecutar las pruebas, los reportes se generan en:
- **Serenity Reports**: `target/site/serenity/index.html`
- **Cucumber Reports**: `target/cucumber-reports/`

Para generar y abrir el reporte de Serenity:
```bash
./gradlew test aggregate
```

## 🧪 Escenarios de Prueba

### Login Feature
- ✅ Login exitoso con credenciales válidas
- ❌ Intento de login con credenciales inválidas

### Shopping Feature
- ✅ Agregar producto al carrito
- ✅ Visualizar inventario de productos

## 🏗️ Patrón Screenplay

Este proyecto implementa el patrón Screenplay que organiza el código en:

- **Actors**: Representan a los usuarios que interactúan con el sistema
- **Tasks**: Acciones de alto nivel que los actores pueden realizar
- **Questions**: Consultas sobre el estado actual del sistema
- **Interactions**: Acciones básicas como click, type, etc.

### Ejemplo de uso:
```java
actor.attemptsTo(
    NavigateToSauceDemo.page(),
    Login.withDefaultCredentials()
);

actor.should(
    Ensure.that(TheLoginStatus.isSuccessful()).isTrue()
);
```

## 🔧 Personalización

### Cambiar navegador
Modifica en `serenity.properties`:
```properties
webdriver.driver=firefox
# o
webdriver.driver=edge
```

### Cambiar credenciales
Modifica en `serenity.properties`:
```properties
saucedemo.username=tu_usuario
saucedemo.password=tu_contraseña
```

### Agregar nuevos escenarios
1. Crea nuevos archivos `.feature` en `src/test/resources/features/`
2. Implementa las definiciones de pasos correspondientes
3. Crea las tareas y preguntas necesarias siguiendo el patrón Screenplay

## 📋 Requisitos del Sistema

- Java 11 o superior
- Gradle 7.0 o superior
- Chrome, Firefox o Edge instalado
- Conexión a internet para descargar dependencias

## 🤝 Contribución

Para contribuir al proyecto:
1. Sigue el patrón Screenplay establecido
2. Escribe pruebas legibles usando Gherkin
3. Mantén la separación de responsabilidades
4. Documenta nuevas funcionalidades

## 📝 Notas Adicionales

- Las pruebas están configuradas para ejecutarse en modo headless por defecto
- Se puede cambiar a modo visual modificando las opciones de Chrome en `serenity.properties`
- Los timeouts están configurados para 30 segundos por defecto
- El proyecto incluye manejo automático de WebDrivers
