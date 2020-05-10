package baseClass;
import static io.restassured.RestAssured.given;

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



public class BaseClass {

    //use for headers,body,parameters
	static protected RequestSpecification reqSpec=null;
	static protected Response response=null;
	static protected Scenario scn=null;
	
	
	protected ResourceBundle bundle=ResourceBundle.getBundle("test");


	
	
	public RequestSpecification getURI(String baseURI)
	{
		return given().baseUri(baseURI);

	}

	public static LocalDate locatDate(){
		LocalDate dt = LocalDate.from(ZonedDateTime.now());
		return dt;

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
