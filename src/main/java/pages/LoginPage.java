package pages;
import utilites.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilites.BrowserActions;
import utilites.Scrolling;
import utilites.elementActions;
import utilites.wait;

import java.util.List;


public class LoginPage
{
    private WebDriver driver;
    public static String UserName;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By USERNAME=By.name("username");
    private final By PASSWORD=By.name("password");
    private  final  By LOGINBTN=By.cssSelector("button[type='submit']");
    private final By Adminpage=By.xpath("//span[text()='Admin']");

    private  final By AddNewRecordBtn=By.xpath("//button[normalize-space()='Add']");
   // private  final By Userroleicon=By.xpath("//label[text()='User Role']/following::div[contains(@class, 'oxd-select-text--after')][1]");
    private  final By Userroleicon=By.xpath("(//div[@class='oxd-select-text-input' and normalize-space(text())='-- Select --'])[1]");

    private  final  By selectESsrole=By.xpath("//div[starts-with(@class, 'oxd-select-option')]//span[text()='ESS']");
    private final By StatusIcon=By.xpath("//label[text()='Status']/following::i[contains(@class, 'oxd-icon')][1]");
    private  final By selectEnabledStatus=By.xpath("//div[starts-with(@class, 'oxd-select-option')]//span[text()='Enabled']");
    private  final By employessname=By.cssSelector("input[placeholder='Type for hints...']");
  //  private final By selectEmployeeOrangeName=By.xpath("//div[@class='oxd-autocomplete-option']//span[text()='sww  test'][1]");
    private final By selectEmployeeOrangeName=By.xpath("//div[@role='listbox']//div[contains(@class, 'oxd-autocomplete-option')][1]//span");
    private final By UserNameL=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By newpassword=By.xpath("(//input[@type='password'])[1]");
    private final By confirmpassword=By.xpath("//label[text()='Confirm Password']/following::input[@type='password']");
    private final By savebtn=By.cssSelector("button[type='submit']");
    private final By SearchUserName=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By GetUserNameCell=By.xpath("(//div[@role='cell'])[2]");
    private final By deleteIcon=By.cssSelector(".oxd-icon.bi-trash");
   private final By deleteOption=By.xpath("//button[normalize-space()='Yes, Delete']");

  public void LoginUsingUsernameAndPassword(String username,String password)
  {
      elementActions.sendData(driver,USERNAME,username);
      elementActions.sendData(driver,PASSWORD,password);
      elementActions.clickElement(driver,LOGINBTN);
  }
  public void checkSucessLogin(String url)
  {
      wait.waitForSec(driver,20);
     System.out.println("hello currentURL is  "+ BrowserActions.getCurrentURL(driver));
      Assert.assertTrue(BrowserActions.getCurrentURL(driver).contains(url),"URL IS wrong,and login failed");
  }
  public int getNoOFRecords()
  {
      wait.waitForSec(driver,15);
      wait.WaitForElementClickable(driver,Adminpage);
      elementActions.ClickByJavaScript(driver,Adminpage);
      List<WebElement> records = driver.findElements(By.cssSelector(".oxd-table-card"));
      int intialcountNOofRecords=records.size();
      return intialcountNOofRecords;
  }
  public void AddNewRecord(String employesname) throws InterruptedException {
      Faker faker = new Faker();
     String Password= faker.internet().password(8, 12, true, true);
       UserName = faker.letterify("??????") + faker.number().digits(2);
      System.out.println("Username is     "+UserName);
      wait.WaitForElementClickable(driver,Adminpage);
      elementActions.ClickByJavaScript(driver,Adminpage);
      elementActions.ClickByJavaScript(driver,AddNewRecordBtn);
      Scrolling.ScrollUP(driver);
      wait.WaitForElementVisible(driver,Userroleicon);
      wait.WaitForElementClickable(driver,Userroleicon);
      elementActions.clickByaActionClass(driver,Userroleicon);
      elementActions.ClickByJavaScript(driver,Userroleicon);
      elementActions.clickElement(driver,selectESsrole);
      wait.WaitForElementVisible(driver,StatusIcon);
      wait.WaitForElementClickable(driver,StatusIcon);
      elementActions.clickByaActionClass(driver,StatusIcon);
      elementActions.clickElement(driver,selectEnabledStatus);
  elementActions.sendData(driver,employessname,employesname);
  wait.WaitForElementVisible(driver,selectEmployeeOrangeName);
  elementActions.clickElement(driver,selectEmployeeOrangeName);
  elementActions.sendData(driver,UserNameL,UserName);
  elementActions.sendData(driver,newpassword,Password);
  elementActions.sendData(driver,confirmpassword,Password);
  //elementActions.clickElement(driver,savebtn);
  elementActions.ClickByJavaScript(driver,savebtn);
  Thread.sleep(8000);
  BrowserActions.refresh(driver);

  }
  public void searchWithCreatedUser()
  {
   wait.WaitForElementVisible(driver,SearchUserName);
   System.out.println("username that I search with is "+UserName);
   elementActions.sendData(driver,SearchUserName,UserName);
   wait.WaitForElementVisible(driver,savebtn);
   wait.WaitForElementClickable(driver,savebtn);
   elementActions.ClickByJavaScript(driver,savebtn);
   //elementActions.clickElement(driver,savebtn);
  }
  public void validateSearchResultContainsUsername()
  {
      wait.waitForSec(driver,6);
      String searchresult=elementActions.getText(driver,GetUserNameCell);
      System.out.println("current search is "+searchresult);
      Assert.assertTrue(elementActions.getText(driver,GetUserNameCell).contains(UserName));
  }
  public void  deleteNewUser()
  {
      elementActions.clickElement(driver,deleteIcon);
      wait.WaitForElementClickable(driver,deleteOption);
      elementActions.clickElement(driver,deleteOption);
  }
}
