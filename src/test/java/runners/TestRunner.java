//package runners;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//
//@CucumberOptions(
//        features = "src/test/resources/features",
//      //  glue = {"stepDefinitions", "com/SprintDemo/hooks"},
//        glue = {"stepDefinitions", "com.SprintDemo.hooks"},
//       // glue = "stepDefinitions",
//        plugin = {"pretty", "html:target/cucumber-report.html"},
//        monochrome = true
//)
//public class TestRunner extends AbstractTestNGCucumberTests {
//}
package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "com.SprintDemo.hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

