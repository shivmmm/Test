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

public class ValidateRequest2 extends BaseClass {
	
	
	
	String uri;
	
	
	
	
	@When("Hit the API with end point as {string}")
	public void hitAPI(String endPoint)
	{
		//Getting reponse throgh get method
		response=reqSpec.get(endPoint);
		System.out.println(response.asString());
		
	}
	
	
	
	
}
