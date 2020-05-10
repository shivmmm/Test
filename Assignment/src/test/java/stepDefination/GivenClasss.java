package stepDefination;



import baseClass.BaseClass;

import cucumber.api.java.en.Given;


public class GivenClasss extends BaseClass {
	
	
	
	
	
	
	@Given("Foreign Exchange Rates API is up and running")
	public void givenAPI()
	{
		//Putting base URI value in requestSpecification object
		scn.write("URI under test -"+bundle.getString("uri"));
		reqSpec=getURI(bundle.getString("uri"));
		
		
	}
	
	
	
	
	
	
}
