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

public class ValidateRequest extends BaseClass {
	
	
	
	String uri;
	
	
	@Given("Foreign Exchange Rates API is up and running")
	public void givenAPI()
	{
		//Putting base URI value in requestSpecification object
		reqSpec=getURI(bundle.getString("uri"));
		
	}
	
	@When("Hit the API with end point as {string}")
	public void hitAPI(String endPoint)
	{
		//Getting reponse throgh get method
		response=reqSpec.get(endPoint);
		System.out.println(response.asString());
		
	}
	
	@Then("API should return the status code as {int}")
	public void getStatusCode(Integer expected)
	{
		//Assertion of status code
		response.then().assertThat().statusCode(expected);
		
	}
	
	@And("Validate base Value {string}")
	public void validateBase(String expectedBase)
	{
		
		//Asserton of Base
		/*JsonPath json=response.jsonPath();
		 
		System.out.println(json.get("base"));*/
		response.then().assertThat().body("base",equalTo(expectedBase));
		
		
	}
	/*@And("Validate the JsonReponse")
	public void validateResponse()
	{
		
		JSONObject actualResponse=new JSONObject(response.asString());
		String expected=readFile("D:\\workspace\\Assignment\\latest.json");
		JSONObject expectedResponse=new JSONObject(expected);
		System.out.println(actualResponse);
		System.out.println(expectedResponse);
		System.out.println(actualResponse.similar(expectedResponse));
	
		
//	}*/
	
	
}
