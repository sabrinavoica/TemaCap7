import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class thisDriver   {

private WebDriver driver;
public thisDriver(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements (driver,this);
}
}
