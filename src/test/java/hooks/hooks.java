package hooks;
//import com.SprintDemo.drivers.DriverManager;
//import com.SprintDemo.utilites.BrowserActions;
import drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilites.BrowserActions;


public class hooks
{

    public static WebDriver driver;

        @Before
        public void setUpDriver() {
          //  driver = new ChromeDriver();
            driver= DriverManager.createInstance("chrome");
            BrowserActions.navigateToURL(driver, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        }

        @After
        public void tearDown() {

            driver.quit();
        }


}


