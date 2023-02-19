package starter.ui.History;

import org.openqa.selenium.By;

public class HistoryUI {

  public static By Button_Menu = By.xpath("//a[contains(@id,'menu-toggle')]");
  public  static  By Button_Hitory = By.xpath("//a[@href='history.php#history'][contains(.,'History')]");
  public  static By Message_Facility =By.xpath("(//p[contains(.,'Tokyo CURA Healthcare Center')])[1]");
  public  static By Message_readmission =By.xpath("(//p[contains(.,'Yes')])[1]");
  public  static By Message_healthcare =By.xpath("(//p[contains(.,'Medicare')])[1]");
  public  static By Message_date =By.xpath("(//div[contains(.,'18/02/2023')])[5]");

}
