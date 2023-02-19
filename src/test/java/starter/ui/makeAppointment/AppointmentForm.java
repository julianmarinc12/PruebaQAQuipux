package starter.ui.makeAppointment;

import org.openqa.selenium.By;

public class AppointmentForm {
   public  static By Button_Make_Appointment =By.id("btn-make-appointment");
  public  static By Select_facility =By.id("combo_facility");
  public  static By Check_box_hospital_readmissionn =By.xpath("//input[contains(@id,'chk_hospotal_readmission')]");
  public  static By Date =By.id("txt_visit_date");
  public  static By Description =By.id("txt_comment");
  public  static By Button_book_Appointment =By.id("btn-book-appointment");
  public  static By Message_Facility =By.xpath("//p[contains(@id,'facility')]");
  public  static By Message_readmission =By.xpath("//p[contains(@id,'readmission')]");
  public  static By Message_healthcare =By.xpath("//p[contains(@id,'program')]");
  public  static By Message_date =By.xpath("//p[contains(@id,'date')]");
  public  static By Message_description =By.xpath("//p[contains(@id,'comment')]");

}
