package CucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

 
@RunWith(Cucumber.class)
@CucumberOptions(features="Feature", glue={"CucumberTest"}, plugin = {"json:src/htmlreport/test-result.json"})
 
public class TestRunner {	

}