import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MakeAppointment extends BaseTest {

    MakeAppointment makeAppointment = new MakeAppointment ();



    @Test(groups = {"login_valid"})
public void makeButtonWhenLoggedIn(){
    driver.findElement (By.id ("btn-make-appointment")).click ();
    Assert.assertTrue (driver.getCurrentUrl ().contains ("#appointment"),
            "User is not redirected to the programming page");

    Select dropsown = new Select (driver.findElement (By.id("combo_facility")));
    dropsown.selectByIndex (1);

    assertTrue(isElementPrsent (By.id ("chk_hospotal_readmission")));
    driver.findElement (By.id ("chk_hospotal_readmission")).click ();

    assertTrue (isElementPrsent (By.id ("radio_program_medicaid")));
    driver.findElement (By.id ("radio_program_medicaid")).click ();

    driver.findElement (By.id ("txt_visit_date")).click ();


    assertTrue (isElementPrsent (By.id ("txt_comment")),
            "Text box is missing");
    driver.findElement (By.id ("txt_comment")).sendKeys ("Text");

    assertTrue (isElementPrsent (By.id ("btn-book-appointment")),
            "Appointment button is missing");
    driver.findElement (By.id ("btn-book-appointment")).click ();

    assertFalse (driver.getCurrentUrl ().contains ("summary"),
            "Appointment cofirmation failed");


}
@Test(groups = {"driver"})
public void makeButtonWhenNotLoggedIn(){
    driver.findElement (By.id ("btn-make-appointment")).click ();
    Assert.assertFalse (driver.getCurrentUrl ().contains ("#appointment"),
            "User is not redirected to the programming page");

    driver.findElement (By.cssSelector ("#txt\\-username")).sendKeys ("John Doe");
    driver.findElement (By.cssSelector ("#txt\\-password")).sendKeys ("ThisIsNotAPassword");
    driver.findElement (By.id ("btn-login")).click ();

    Select dropsown = new Select (driver.findElement (By.id("combo_facility")));
    dropsown.selectByIndex (1);

    assertTrue(isElementPrsent (By.id ("chk_hospotal_readmission")));
    driver.findElement (By.id ("chk_hospotal_readmission")).click ();

    assertTrue (isElementPrsent (By.id ("radio_program_medicaid")));
    driver.findElement (By.id ("radio_program_medicaid")).click ();

   WebElement text = driver.findElement (By.id ("txt_visit_date"));
   text.click ();
   text.sendKeys ("26082022");



    assertTrue (isElementPrsent (By.id ("txt_comment")),
            "Text box is missing");
    driver.findElement (By.id ("txt_comment")).sendKeys ("Text");

    assertTrue (isElementPrsent (By.id ("btn-book-appointment")),
            "Appointment button is missing");
    driver.findElement (By.id ("btn-book-appointment")).click ();

    assertTrue (driver.getCurrentUrl ().contains ("summary"),
            "The appointment could not be made");



}
}
