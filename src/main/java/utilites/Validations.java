package com.SprintDemo.utilites;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {

    public static void validationTrue(boolean condition,String message){
        Assert.assertTrue(condition,message);

    }
    public static void validationfalse(boolean condition,String message){
        Assert.assertFalse(condition,message);
    }
    public static void validatEqual(String Actual,String Expected,String message){
        Assert.assertEquals(Actual,Expected,message);
    }
    public static void validaateNotEqual(String Actual,String Expected,String  message){
        Assert.assertNotSame(Actual,Expected,message);
    }
    public  static void validatePageUrl(WebDriver driver,String Expected)
    {
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),Expected);
    }
    public  static void validatePageTitle(WebDriver driver,String Expected)
    {
        Assert.assertEquals(BrowserActions.getPageTitle(driver),Expected);
    }


}
