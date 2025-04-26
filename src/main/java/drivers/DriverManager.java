package drivers;

//import com.SprintDemo.utilites.LogsUtil;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private DriverManager() {
        super();
    }

    private static final ThreadLocal<WebDriver> DriverThreadLocal = new ThreadLocal<>();

    public static WebDriver createInstance(String BrowserName)
    {
        WebDriver driver=BrowserFactory.getBrowser(BrowserName);
       // LogsUtil.info("driver created:" +BrowserName);
        setDriver(driver);
        return  getDriver();
    }
    public static void setDriver(WebDriver driver) {
        DriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        if (DriverThreadLocal.get() == null) {
            System.out.println("driver is null");
        }

        return DriverThreadLocal.get();
    }
}
