package stepDefination;



import baseClass.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import java.text.ParseException;
import java.time.LocalDate;

import org.json.JSONObject;

public class ThenClass extends BaseClass {
	
	
	
	
	
	
	
	@Then("API should return the status code as {int}")
	public void getStatusCode(Integer expected)
	{
		//Assertion of status code
		scn.write("Extracting status code to validate");
		response.then().assertThat().statusCode(expected);
		
		
	}
	@Then("API should return the current date rates")
	public void validateDate() throws ParseException
	{
		scn.write("Verifying current date data should return even if the endpoint is of future date");
		//Assertion of status code
		validatingDate();
		
		
	}
	
	@And("Error message should displayed as {string}")
	public void validateErrorMessage(String expectedError)
	{
		scn.write("Verifying error message for incorrect endpoint");
		response.then().assertThat().body("error",equalTo(expectedError));
	}
	
	@Then("Base Value should be {string}")
	public void validateBase(String expectedBase)
	{
		
		//Asserton of Base
		/*JsonPath json=response.jsonPath();
		 
		System.out.println(json.get("base"));*/
		scn.write("Verifying base value");
		
		response.then().assertThat().body("base",equalTo(expectedBase));
		
		
	}
	
	
	
	
}
