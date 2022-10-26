@ChallengeWeb
Feature: Plataforma Web para Alta de usuarios y agregar producto.

  @AltaUsuario
  Scenario Outline: Dar de alta un nuevo usuario
    Given que ingresamos a la web de Product Store
    When seleccionamos la opcion del menu Sing up
    And ingresamos el "<nombre_usuario>" y la "<contrasenia_usuario>"
    And presionamos el boton Sign up
    Then se da de alta el usuario con exito

    Examples:
      | nombre_usuario | contrasenia_usuario  |
      | Bahubali5       | Bahubali5           |

  @LoginAndLogout
  Scenario Outline: Ingresar y salir de la web de Product Store
    Given que ingresamos a la web de Product Store
    When seleccionamos la opcion del menu Login
    And ingresamos nuestro "<usuario>" y "<contrasenia>"
    And presionamos el boton Login
    Then presionar el boton Logout

    Examples:
      | usuario   | contrasenia  |
      | Bahubali5 | Bahubali5    |


  @AgregarACarritoYComprobar
  Scenario Outline: Agregar una laptop al carrito
    Given que ingresamos a la web de Product Store
    When seleccionamos la opcion del menu Login
    And ingresamos nuestro "<usuario>" y "<contrasenia>"
    And presionamos el boton Login
    And nos dirigimos a la "<categoria>"
    And seleccionamos el "<modelo>"
    And agregamos al carrito
    Then comprobamos que se haya agregado al carrito

    Examples:
      | usuario   | contrasenia  | categoria |    modelo    |
      | Bahubali5 | Bahubali5    | Laptops   |  MacBook Pro |
