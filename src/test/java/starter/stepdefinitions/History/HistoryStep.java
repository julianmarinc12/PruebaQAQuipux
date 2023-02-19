package starter.stepdefinitions.History;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.navigation.NavigateTo;
import starter.questions.History.QDateH;
import starter.questions.History.QHealthcareH;
import starter.questions.History.QReadmissionH;
import starter.questions.History.QfacilityH;
import starter.questions.makeAppointment.*;
import starter.task.History.HistoryTask;
import starter.task.home.HomeToLogin;
import starter.task.login.DoLogin;
import starter.task.makeAppointment.ApointmentMake;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class HistoryStep {

  String name;
  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Given("^(.*) debe estar logeado")
  public void julian_debe_estar_logeado(String name) {
    this.name = name;
    theActorCalled(name).attemptsTo(
        NavigateTo.DemoCuroHomepage(),
        HomeToLogin.redirectLogin(),
        DoLogin.WithCredentials("John Doe","ThisIsNotAPassword")
    );

  }

  @Given("se diligencia el formularo")
  public void se_diligencia_el_formularo() {
    theActorCalled(name).attemptsTo(
        ApointmentMake.Make("Tokyo CURA Healthcare Center","18022023","todo esta bien")
    );
  }

  @When("se redireccina a Historia")
  public void se_redireccina_a_historia() {
    theActorCalled(name).attemptsTo(
        HistoryTask.redirectHistory()
    );
  }

  @Then("se debe ver reflejado la cita antoriormente programada")
  public void se_debe_ver_reflejado_la_cita_antoriormente_programada() {
    theActorInTheSpotlight().should(
        seeThat("se puede ver facility", QfacilityH.value(),equalTo("Tokyo CURA Healthcare Center")),
        seeThat("se puede ver readmission", QReadmissionH.value(),equalTo("Yes")),
        seeThat("se puede ver healthcare", QHealthcareH.value(),equalTo("Medicare"))
    );

  }

}
