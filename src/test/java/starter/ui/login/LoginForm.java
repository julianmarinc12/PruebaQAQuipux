package starter.ui.login;

import org.openqa.selenium.By;

public class LoginForm {
  public static By USERNAME_FIELD = By.id("txt-username");
  public static  By PASSWORD_FIELD =By.id("txt-password");
  public static  By LOGIN_BUTTON = By.id("btn-login");

  public static  By Message_Login = By.xpath("//p[@class='lead text-danger'][contains(.,'Login failed! Please ensure the username and password are valid.')]");
   public  static  By Message_Login_Valido = By.xpath("//h2[contains(.,'Make Appointment')]");
}
