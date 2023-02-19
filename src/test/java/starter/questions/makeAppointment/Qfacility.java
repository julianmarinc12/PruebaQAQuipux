package starter.questions.makeAppointment;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import starter.questions.login.QLoginVacio;
import starter.ui.makeAppointment.AppointmentForm;

public class Qfacility implements Question<String> {

  public static Question<String> value(){
    return new Qfacility();
  }
  @Override
  public String answeredBy(Actor actor) {
    return BrowseTheWeb.as(actor).find(AppointmentForm.Message_Facility).getText().trim();
  }
}
