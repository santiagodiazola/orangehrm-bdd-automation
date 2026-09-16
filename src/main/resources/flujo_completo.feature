Feature: Flujo completo en OrangeHRM

  Scenario: Login exitoso
    # Steps for login
    Given que el usuario navega a la página de login de OrangeHRM
    When ingresa las credenciales válidas
    Then el usuario debería ver el Dashboard


  Scenario Outline: Buscar empleado
    # Steps for login, PIM navigation, and employee search
    Given que el usuario ha iniciado sesión exitosamente
    When navega al módulo PIM y busca al empleado "<EmployeeName>"
    Then el registro del empleado debería aparecer en los resultados

    Examples:
      | EmployeeName |
      | John         |



  Scenario Outline: Flujo completo E2E
    # Steps for login, employee search, and logout
    Given que el usuario ha iniciado sesión exitosamente
    When navega al módulo PIM y busca al empleado "<EmployeeName>"
    And hace clic en logout
    Then el usuario debería regresar a la página de login

    Examples:
      | EmployeeName |
      | John         |

