package starter.task.makeAppointment;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SetCheckbox;
import starter.ui.makeAppointment.AppointmentForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ApointmentMake implements Task {

  private final String facility;
  private final String date;
  private  final String description;

  public ApointmentMake(String facility, String date, String description) {
    this.facility = facility;
    this.date = date;
    this.description = description;
  }

  public static Performable Make(String facility, String date, String description){
    return instrumented(ApointmentMake.class,facility,date,description);
  }
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(AppointmentForm.Button_Make_Appointment),
        SelectFromOptions.byVisibleText(facility).from(AppointmentForm.Select_facility),
        SetCheckbox.of("//input[contains(@id,'chk_hospotal_readmission')]").toTrue(),
        Enter.theValue(date).into(AppointmentForm.Date),
        Enter.theValue(description).into(AppointmentForm.Description),
        Click.on(AppointmentForm.Button_book_Appointment)

    );
  }
}
