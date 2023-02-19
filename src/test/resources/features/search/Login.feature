Feature: con este feature se pretende  testear los escenario de login

  Background:
    Given julian esta en la pagina login

  @LoginSinDatos
  Scenario: julian da clic a logear sin ingresar usuario y clave
    When julian da clic en el boton login
    Then debe aparecer anuncio de error

  @LoginDatosMalos
  Scenario: julian ingresa mal usuario y clave
    When julian ingresa usuario y clave errada
    Then debe aparecer anuncio de error credenciales invalidas

  @LoginCorrecto
  Scenario: julian ingresa correctamente al formulario
    When julian ingresa usuario y clave correctos
    Then se puede visualizar el formulario