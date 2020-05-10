package stepDefination;



import baseClass.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class WhenClass extends BaseClass {
	
	
	
	
	
	
	@When("Hit the API with end point as {string}")
	public void hitAPI(String endPoint)
	{
		scn.write("Hiting API with specific endpoint "+endPoint);
		//Getting reponse throgh get method
		response=reqSpec.get(endPoint);
		
		
	}
	
	
	
	
}
