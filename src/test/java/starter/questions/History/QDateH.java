package starter.questions.History;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import starter.ui.History.HistoryUI;
import starter.ui.makeAppointment.AppointmentForm;

public class QDateH implements Question<String> {

  public static Question<String> value(){
    return new QDateH();
  }

  @Override
  public String answeredBy(Actor actor) {
    return BrowseTheWeb.as(actor).find(HistoryUI.Message_date).getText().trim();
  }
}
