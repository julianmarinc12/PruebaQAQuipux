package starter.task.History;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.task.home.HomeToLogin;
import starter.ui.History.HistoryUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HistoryTask implements Task {

  public static Performable redirectHistory(){
    return instrumented(HistoryTask.class);
  }
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(HistoryUI.Button_Menu),
        Click.on(HistoryUI.Button_Hitory)
    );
  }
}
