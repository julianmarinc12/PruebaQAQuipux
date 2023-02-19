package starter.stepdefinitions.makeAppoin;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.navigation.NavigateTo;
import starter.questions.makeAppointment.*;
import starter.task.home.HomeToLogin;
import starter.task.login.DoLogin;
import starter.task.makeAppointment.ApointmentMake;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class Appointment {

  String name;
  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }


  @Given("^(.*) esta logeado y en el formulario")
  public void julian_esta_logeado_y_en_el_formulario(String name) {
    this.name = name;
    theActorCalled(name).attemptsTo(
        NavigateTo.DemoCuroHomepage(),
        HomeToLogin.redirectLogin(),
        DoLogin.WithCredentials("John Doe","ThisIsNotAPassword")
    );

  }

  @When("julian ingresa informacion de diferente formas")
  public void julian_ingresa_informacion_de_diferente_formas() {
    theActorCalled(name).attemptsTo(
        ApointmentMake.Make("Tokyo CURA Healthcare Center","18022023","todo esta bien")
    );
  }

  @Then("se debe visualizar")
  public void se_debe_visualizar() {
    theActorInTheSpotlight().should(
        seeThat("se puede ver facility", Qfacility.value(),equalTo("Tokyo CURA Healthcare Center")),
        seeThat("se puede ver readmission", QReadmission.value(),equalTo("Yes")),
        seeThat("se puede ver healthcare", QHealthcare.value(),equalTo("Medicare")),
        seeThat("se puede ver date", QDate.value(),equalTo("18/02/2023")),
        seeThat("se puede ver comment", QComment.value(),equalTo("todo esta bien"))
    );

  }
}
