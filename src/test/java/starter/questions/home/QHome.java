package starter.questions.home;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import starter.ui.home.Home;

public class QHome implements Question<String> {

  public static Question<String> value(){
    return new QHome();
  }
  @Override
  public String answeredBy(Actor actor) {
    return BrowseTheWeb.as(actor).find(Home.MessageHome).getText().trim();
  }
}
