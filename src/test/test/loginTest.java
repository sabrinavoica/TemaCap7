import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
 public class loginTest extends BaseTest {




    @Test(groups = {"login_valid"})
    public void loginValidSteps(){
        assertTrue (driver.getCurrentUrl ().contains ("#appointment"),
                "The user was not redirected to the appointment page");
        System.out.println ("Valid login program has ended.");

    }

    @Test(groups = {"login_invalid"})
    public void loginInvalidSteps() {
        assertFalse (driver.getCurrentUrl ().contains ("#appointment"),
                "fgh");
        System.out.println ("Invalid login program has ended.");
    }





}
