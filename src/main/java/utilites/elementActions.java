package com.SprintDemo.utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class elementActions {
    private elementActions() {
    }

    //sendkey method
    public static void sendData(WebDriver driver, By locator, String Data) {
        wait.WaitForElementVisible(driver, locator);
        Scrolling.scrolToElemenet(driver, locator);
        findElement(driver,locator).sendKeys(Data);
       // LogsUtil.info("data is send to ",Data);

    }

    //click element
    public static void clickElement(WebDriver driver, By locator) {
        wait.WaitForElementVisible(driver, locator);
        Scrolling.scrolToElemenet(driver, locator);
        findElement(driver,locator).click();
       // LogsUtil.info(locator.toString(),"button  should be clicked now");

    }

    public  static String getText(WebDriver driver,By locator)
    {
        wait.WaitForElementVisible(driver, locator);
        Scrolling.scrolToElemenet(driver, locator);
         return findElement(driver,locator).getText();
    }
    public static WebElement findElement(WebDriver driver, By locator)
    {
    return driver.findElement(locator);
    }
public static void ClickByJavaScript(WebDriver driver,By locator)
{
    WebElement element = driver.findElement(locator);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", element);

}
public  static void clickByaActionClass(WebDriver driver,By loactor){
    Actions actions = new Actions(driver);

    WebElement dropdown = driver.findElement(loactor);

// Move to the element and click
    actions.moveToElement(dropdown).click().build().perform();
}
public static  void getTextFromDropDownList(WebDriver driver,By locator,String text)
{
    WebElement dropdown = driver.findElement(locator);
    Select select = new Select(dropdown);

    List<WebElement> allOptions = select.getOptions();

    for (WebElement option : allOptions) {
        if (option.getText().equals(text)) {
            String value = option.getAttribute("value");
            System.out.println("Found value: " + value);
            break;
        }
    }
}

    public static void selectByVisibleText(WebDriver driver, By locator, String visibleText) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

}



