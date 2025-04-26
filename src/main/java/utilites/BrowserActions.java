package utilites;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions() {
    }

    public static void navigateToURL(WebDriver driver, String url)
    {
        driver.get(url);

    }
    public static String getCurrentURL(WebDriver driver){

        return driver.getCurrentUrl();
    }
    public static String getPageTitle(WebDriver driver)
    {

        return driver.getTitle();
    }
    public static void refresh(WebDriver driver)
    {
        driver.navigate().refresh();
    }
}
