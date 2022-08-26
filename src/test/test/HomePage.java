import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HomePage extends BaseTest {


    @Test(groups = {"login_valid"})
    public void homeButtonWhenLoggedIn(){
        driver.findElement (By.id ("menu-toggle")).click ();

        driver.findElement (By.cssSelector ("a[href=\"history.php#history\"")).click ();

        driver.findElement (By.id ("menu-toggle")).click ();
        driver.findElement (By.cssSelector ("a[href='./")).click ();
        assertTrue (isElementPrsent (By.cssSelector ("a[href='./' ")),
                "Button not identified");

        driver.findElement (By.id ("btn-make-appointment")).click ();
        Assert.assertFalse (driver.getCurrentUrl ().contains ("#appointment"),
                "User is not redirected to the programming page");
        Select dropsown = new Select (driver.findElement (By.id("combo_facility")));
        dropsown.selectByIndex (1);

        assertTrue(isElementPrsent (By.id ("chk_hospotal_readmission")));
        driver.findElement (By.id ("chk_hospotal_readmission")).click ();

        assertTrue (isElementPrsent (By.id ("radio_program_medicaid")));
        driver.findElement (By.id ("radio_program_medicaid")).click ();

        driver.findElement (By.id ("txt_visit_date")).click ();
        driver.findElement (By.id ("txt_visit_date")).sendKeys ("02032022");

        assertTrue (isElementPrsent (By.id ("txt_comment")),
                "Text box is missing");
        driver.findElement (By.id ("txt_comment")).sendKeys ("Text");
        assertTrue (isElementPrsent (By.id ("btn-book-appointment")),
                "Book Appointment button has been accessed");

        driver.findElement (By.id ("menu-toggle")).click ();
        driver.findElement (By.cssSelector ("a[href='authenticate.php?logout")).click ();


    }
    @Test(groups = {"driver"})
    public void homeButtonWhenNotLoggedIn(){
//        driver.findElement (By.id ("menu-toggle")).click ();
//        driver.findElement (By.cssSelector ("a[href='authenticate.php?logout")).click ();

        driver.findElement (By.id ("menu-toggle")).click ();
        driver.findElement (By.cssSelector ("a[href='./")).click ();
        assertTrue (isElementPrsent (By.cssSelector ("a[href='./' ")),
                "Button not identified");

        driver.findElement (By.id ("menu-toggle")).click ();
        driver.findElement (By.cssSelector ("a[href='profile.php#login")).click ();
        driver.findElement (By.cssSelector ("#txt\\-username")).sendKeys ("John Doe");
        driver.findElement (By.cssSelector ("#txt\\-password")).sendKeys ("ThisIsNotAPassword");
        driver.findElement (By.id ("btn-login")).click ();
        assertTrue (driver.getCurrentUrl ().contains ("#appointment"));
        assertTrue (isElementPrsent (By.cssSelector ("a[href='authenticate.php?logout")),
                "gujjjjf");



    }
}
