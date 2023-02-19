package starter.ui.home;

import org.openqa.selenium.By;

public class Home {

  public static By Button_Make_Appointment = By.id("btn-make-appointment");
  public  static  By MessageHome = By.xpath("//p[@class='lead'][contains(.,'Please login to make appointment.')]");
}
