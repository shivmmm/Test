package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/featureFiles", glue = "stepDefination", tags = { "@Regression,@Acceptance" },

		plugin = { "pretty", "html:target/html/", })
public class TestRunner {

}
