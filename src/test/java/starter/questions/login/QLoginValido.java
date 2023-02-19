package starter.questions.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import starter.ui.login.LoginForm;

public class QLoginValido implements Question<String> {

  public static Question<String> value(){
    return new QLoginValido();
  }

  @Override
  public String answeredBy(Actor actor) {
    return BrowseTheWeb.as(actor).find(LoginForm.Message_Login_Valido).getText().trim();
  }
}
