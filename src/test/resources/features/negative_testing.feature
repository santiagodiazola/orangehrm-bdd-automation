Feature: Pruebas Negativas en OrangeHRM

  Scenario: Login fallido con credenciales incorrectas
    Given que el usuario navega a la página de login de OrangeHRM
    When ingresa credenciales inválidas
    Then debería ver un mensaje de error de credenciales inválidas

  Scenario: Buscar empleado que no existe
    # Steps for login, PIM navigation, and employee search
    Given que el usuario ha iniciado sesión exitosamente
    When navega al módulo PIM y busca al empleado "Santiago"
    Then debería ver el mensaje de que no hay registros

