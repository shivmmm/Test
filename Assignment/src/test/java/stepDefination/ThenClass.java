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
	
	LocalDate dt;
	

	
	
	
	
	@Then("API should return the status code as {int}")
	public void getStatusCode(Integer expected)
	{
		//Assertion of status code
		
		response.then().assertThat().statusCode(expected);
		
		
	}
	@Then("API should return the current date rates")
	public void validateDate() throws ParseException
	{
		
		//Assertion of status code
		dt=	locatDate();
		String date=checkWeekends(dt);
		
		response.then().assertThat().body("date",equalTo(date));
		
	}
	
	@And("Error message should displayed as {string}")
	public void validateErrorMessage(String expectedError)
	{
		
		response.then().assertThat().body("error",equalTo(expectedError));
	}
	
	@Then("Base Value should be {string}")
	public void validateBase(String expectedBase)
	{
		
		//Asserton of Base
		/*JsonPath json=response.jsonPath();
		 
		System.out.println(json.get("base"));*/
		
		response.then().assertThat().body("base",equalTo(expectedBase));
		
		
	}
	
	
	
	
}
