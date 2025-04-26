package utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling
{
    private Scrolling()
    {

    }

    public static void scrolToElemenet(WebDriver driver, By locator)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementActions.findElement(driver,locator));
    }
    public  static  void ScrollUP(WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll up the page to the top (x=0, y=0)
        js.executeScript("window.scrollTo(0, 0)");
        //LogsUtil.info("page should be scrolled up now ");
    }
}
