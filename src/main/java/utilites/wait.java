package utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class wait {
    static WebDriver driver;
private wait()
{

}
    //method to present web element
    public  static  WebElement waitForElementPresent(WebDriver driver, By Locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> driver.findElement(Locator));
    }

    public  static WebElement WaitForElementVisible(WebDriver driver, By Locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Use ExpectedConditions to wait for the element to be visible
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));

    }
    public  static  void waitForSec(WebDriver driver,int second){
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);

    }
    public  static WebElement WaitForElementClickable(WebDriver driver, By Locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Use ExpectedConditions to wait for the element to be visible
        return wait.until(ExpectedConditions.elementToBeClickable(Locator));

    }
}
