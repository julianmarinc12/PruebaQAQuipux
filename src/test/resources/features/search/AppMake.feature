Feature: diligenciar formulario make appointment

  @creandoCita
  Scenario: Julian diligencia el formulario de diferentes formas
    Given julian esta logeado y en el formulario
    When julian ingresa informacion de diferente formas
    Then se debe visualizar