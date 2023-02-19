package starter.stepdefinitions.login;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.navigation.NavigateTo;
import starter.questions.login.QLoginVacio;
import starter.questions.login.QLoginValido;
import starter.task.login.DoLogin;
import starter.task.home.HomeToLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class login {

  String name;
  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Given("^(.*) esta en la pagina login")
  public void julian_esta_en_la_pagina_login(String name) {
    this.name = name;
    theActorCalled(name).attemptsTo(
        NavigateTo.DemoCuroHomepage(),
        HomeToLogin.redirectLogin()
    );
  }

  @When("julian da clic en el boton login")
  public void julian_da_clic_en_el_boton_login() {
    theActorCalled(name).attemptsTo(
        DoLogin.WithCredentials("","")
    );
  }

  @Then("debe aparecer anuncio de error")
  public void debe_aparecer_anuncio_de_error() {
    theActorInTheSpotlight().should(
        seeThat("Aparece Error de ogin", QLoginVacio.value(),equalTo("Login failed! Please ensure the username and password are valid."))
    );
  }

  @When("julian ingresa usuario y clave errada")
  public void julian_ingresa_usuario_y_clave_errada() {
    theActorCalled(name).attemptsTo(
        DoLogin.WithCredentials("userNoValido","passwordNoValida")
    );
  }
  @Then("debe aparecer anuncio de error credenciales invalidas")
  public void debe_aparecer_anuncio_de_error_credenciales_invalidas() {
    theActorInTheSpotlight().should(
        seeThat("Aparece Error de ogin", QLoginVacio.value(),equalTo("Login failed! Please ensure the username and password are valid."))
    );
  }

  @When("julian ingresa usuario y clave correctos")
  public void julian_ingresa_usuario_y_clave_correctos() {
    theActorCalled(name).attemptsTo(
        DoLogin.WithCredentials("John Doe","ThisIsNotAPassword")
    );

  }

  @Then("se puede visualizar el formulario")
  public void se_puede_visualizar_el_formulario() {
    theActorInTheSpotlight().should(
        seeThat("se puede ver el formulario", QLoginValido.value(),equalTo("Make Appointment"))
    );

  }

}
