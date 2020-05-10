package runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/stepDefination",
				glue="stepDefination",
				tags= {"@Accpetance"},
		plugin = {"pretty",
				"html:target/html/",
				"json:target/json/file.json"}
		)
public class TestRunner {



}
