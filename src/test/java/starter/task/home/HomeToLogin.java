package starter.task.home;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.ui.home.Home;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HomeToLogin implements Task {

  public static Performable redirectLogin(){
    return instrumented(HomeToLogin.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(Home.Button_Make_Appointment)
    );


  }
}
