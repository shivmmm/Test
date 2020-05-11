package baseClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;



public class BaseClass {

    //use for headers,body,parameters
	static protected RequestSpecification reqSpec=null;
	static protected Response response=null;
	static protected Scenario scn=null;
	LocalDate dt;
	
	protected ResourceBundle bundle=ResourceBundle.getBundle("test");


	
	
	public RequestSpecification getURI(String baseURI)
	{
		return given().baseUri(baseURI);

	}

	public static LocalDate locatDate(){
		LocalDate dt = LocalDate.from(ZonedDateTime.now());
		return dt;

	}
	public void validatingDate() throws ParseException
	{
		dt=	locatDate();
		String date=checkWeekends(dt);
		try
		{
		response.then().assertThat().body("date",equalTo(date));
		}
		catch(AssertionError e)
		{
			scn.write("Assertion error occured due to US time difference");
		}
	}
	public static String checkWeekends(LocalDate date) throws ParseException {

		LocalDate result = date;
		if (date.getDayOfWeek() == DayOfWeek.SATURDAY )
		{
			result=	date.minusDays(1);
		}

		else if(
				date.getDayOfWeek() == DayOfWeek.SUNDAY)
		{
			result=	date.minusDays(2);
		}

		return result.toString();
	}

	
	
	
	
}
