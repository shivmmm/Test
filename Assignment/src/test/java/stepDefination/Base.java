package stepDefination;

import baseClass.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Base extends BaseClass
{
	

	
	



	@Before
	public void SetUp(Scenario s) 
	{
		scn =s ;
	}
	
	
	@After
	public void CleanUp() {
		reqSpec=null;
		response=null;
	}
	
	

}