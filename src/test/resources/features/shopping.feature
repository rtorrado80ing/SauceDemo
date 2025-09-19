# language: es
Característica: Funcionalidad de compras en SauceDemo
  Como un usuario autenticado de SauceDemo
  Quiero poder agregar productos a mi carrito
  Para poder comprar artículos

  Antecedentes:
    Dado que el usuario está en la página de inicio de sesión de SauceDemo
    Y el usuario inicia sesión con credenciales estándar

  @smoke @shopping
  Escenario: Agregar un producto al carrito de compras
    Cuando el usuario agrega el primer producto al carrito
    Entonces el carrito de compras debería mostrar 1 artículo
    Y la insignia del carrito debería ser visible

  @shopping
  Escenario: Ver productos en la página de inventario
    Entonces el usuario debería ver el inventario de productos
    Y múltiples productos deberían estar disponibles para compra