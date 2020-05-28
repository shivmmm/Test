package stepDefination;



import baseClass.BaseClass;
import cucumber.api.java.en.Given;


public class GivenClass extends BaseClass {
	
	
	
	//all given will come in this class 
	
	
	@Given("Foreign Exchange Rates API is up and running")
	public void givenAPI()
	{
		//Putting base URI value in requestSpecification object
		scn.write("URI under test -"+bundle.getString("uri"));
		reqSpec=getURI(bundle.getString("uri"));
		
		
	}
	
	
	
	
	
	
}
