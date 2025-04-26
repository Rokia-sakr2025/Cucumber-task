package stepDefinitions;

//import com.SprintDemo.drivers.DriverManager;
//import com.SprintDemo.pages.loginPage;
//import com.SprintDemo.utilites.BrowserActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import drivers.DriverManager;
import drivers.BrowserFactory;
import utilites.elementActions;
import utilites.BrowserActions;



public class LoginStep {
    private WebDriver driver;
//    public loginStep(WebDriver driver) {
//        this.driver = driver;
//    }
//public loginStep(hooks hooks) {
//    this.driver = hooks.getDriver();
//    //this.loginpage = new loginPage(driver);
//}
//public loginStep(DriverManager manager) {
//    this.driver = manager.getDriver();
//}
public LoginStep(){
    this.driver = DriverManager.getDriver();
}
   int currentRecord;
   int   CountAfterADD;
    @Given("user is on login page")
    public void user_is_on_login_page()
    {
        System.out.println("hello with first test");
        System.out.println("helloooo");
    }

    @When("user login with username {string} and password {string}")
    public void user_login_with_username_and_password(String username, String password) {

        LoginPage loginPage=new LoginPage(driver);
        loginPage.LoginUsingUsernameAndPassword(username,password);
    }



    @Then("user logged sucessfully and go to {string}")
    public void user_Logged_Sucessfully_And_Go_To(String expectedURL)
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.checkSucessLogin(expectedURL);
    }

    @When("Add new record with employeename {string} and username {string} and password {string}")
    public void add_New_Record_With_Employeename_And_Username_And_Password(String name, String username, String password) {

        LoginPage loginPage=new LoginPage(driver);

       // loginpage.AddNewRecord(name,username,password);
    }

    @When("I get current records")
    public void i_Get_Current_Records()
    {
        LoginPage loginPage=new LoginPage(driver);
        currentRecord= loginPage.getNoOFRecords();
        System.out.println("current record count is "+currentRecord);
    }

    @And("Add new Record with employeeName {string}")
    public void add_New_Record_With_EmployeeName(String employeename) throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.AddNewRecord(employeename);
        Thread.sleep(7000);
       // wait.waitForSec(driver,15);
    }

    @Then("Verify that the number of records increased by one")
    public void verify_That_The_Number_Of_Records_Increased_By_One() {
        LoginPage loginPage=new LoginPage(driver);
       // BrowserActions.refresh(driver);
         CountAfterADD=loginPage.getNoOFRecords();
        System.out.println("Count after add is "+CountAfterADD);
        Assert.assertEquals(CountAfterADD, currentRecord + 1, "Record count did not increase by 1 after adding.");
    }

    @When("I Search with the username for the new user")
    public void i_Search_With_The_Username_For_The_New_User() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.searchWithCreatedUser();
    }

    @Then("varify that new user is displayed in result search")
    public void varifyThatNewUserIsDisplayedInResultSearch()
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.validateSearchResultContainsUsername();
    }

    @Then("Varify that the number is records decreased by one")
    public void varify_That_The_Number_Is_Records_Decreased_By_One()
    {
        LoginPage loginPage=new LoginPage(driver);
        BrowserActions.refresh(driver);
        int CountAfterDelete=loginPage.getNoOFRecords();
        System.out.println("Count after delete is "+CountAfterDelete);
        Assert.assertEquals(CountAfterDelete, CountAfterADD - 1, "Record count did not increase by 1 after adding.");
    }

    @When("I delete the newly created user")
    public void i_Delete_The_Newly_Created_User() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.deleteNewUser();

    }
}
