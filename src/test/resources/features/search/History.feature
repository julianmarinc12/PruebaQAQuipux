Feature: se va visulizar las citas programadas por julian

  @history
  Scenario: ver historia de citas del pasiente
    Given julian debe estar logeado
    And se diligencia el formularo
    When se redireccina a Historia
    Then se debe ver reflejado la cita antoriormente programada