import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;

public class BaseTest   {

   protected static ChromeDriver driver = null;




    @BeforeMethod(onlyForGroups = {"driver"})
   protected void beforeMethod(){
       driver = WebDriverMAAN.getChromeDriver ();
       driver.get ("https://katalon-demo-cura.herokuapp.com/");

   }

    @BeforeMethod(onlyForGroups = {"login_valid"})
    protected void loginWithValidCredentials(){
       driver = WebDriverMAAN.getChromeDriver ();
       driver.get ("https://katalon-demo-cura.herokuapp.com/");
        System.out.println ("Programul de login a inceput");

        driver.findElement (By.id ("menu-toggle")).click ();
        driver.findElement (By.cssSelector ("a[href='profile.php#login")).click ();
        driver.findElement (By.cssSelector ("#txt\\-username")).sendKeys ("John Doe");
        driver.findElement (By.cssSelector ("#txt\\-password")).sendKeys ("ThisIsNotAPassword");
        driver.findElement (By.id ("btn-login")).click ();

    }


    @BeforeMethod(onlyForGroups = {"login_invalid"})
    protected void loginWithInvalidCredentials(){
        driver = WebDriverMAAN.getChromeDriver ();
        driver.get ("https://katalon-demo-cura.herokuapp.com/");
        System.out.println ("Programul de login a inceput");

        driver.findElement (By.id ("menu-toggle")).click ();
        driver.findElement (By.cssSelector ("a[href='profile.php#login")).click ();
        driver.findElement (By.cssSelector ("#txt\\-username")).sendKeys ("Voica Sabrina");
        driver.findElement (By.cssSelector ("#txt\\-password")).sendKeys ("12345678");
        driver.findElement (By.id ("btn-login")).click ();

    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        if (driver != null){
            driver.quit ();
        }
    }

    protected boolean isElementPrsent(By locator){
        try {
            driver.findElement (locator);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }

    }





//    @FindBy(className = "menu-toggle")
//    public static WebElement rightButton;
//
//    @FindBy(css = "a[href='profile.php#login")
//    public static WebElement loginButtonFromMenu;
//
//    @FindBy(css = "#txt\\-username")
//    public static WebElement username;
//
//    @FindBy(css = "#txt\\-password")
//    public static WebElement password;
//
//    @FindBy(id = "btn-login" )
//    public static WebElement loginButton;



//    protected static void loginWithValidCredentials(){
//        driver = WebDriverMAAN.getChromeDriver ();
//        driver.get ("https://katalon-demo-cura.herokuapp.com/");

    //    WebElement rightButton = driver.findElement (By.className ("menu-toggle"));
    //    rightButton.click ();

    //    WebElement loginButtonFromMenu = driver.findElement (By.cssSelector ("a[href='profile.php#login"));
    //    loginButtonFromMenu.click ();

    //    WebElement username = driver.findElement (By.cssSelector ("#txt\\-username"));
     //   username.sendKeys ("John Doe");

     //   WebElement password = driver.findElement (By.cssSelector ("#txt\\-password"));
     //   password.sendKeys ("ThisIsNotAPassword");

    //    WebElement loginButton = driver.findElement (By.id ("btn-login"));
     //   loginButton.click ();

//        driver.findElement (By.className ("menu-toggle")).click ();
//        driver.findElement (By.cssSelector ("a[href='profile.php#login")).click ();
//        driver.findElement (By.cssSelector ("#txt\\-username")).sendKeys ("John Doe");
//        driver.findElement (By.cssSelector ("#txt\\-password")).sendKeys ("ThisIsNotAPassword");
//        driver.findElement (By.id ("btn-login")).click ();
//    }
}
