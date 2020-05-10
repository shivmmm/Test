package baseClass;
import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ResourceBundle;

import cucumber.api.Scenario;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class BaseClass {

    //use for headers,body,parameters
	protected RequestSpecification reqSpec=null;
	 protected Response response=null;
	protected Scenario scn=null;

	protected ResourceBundle bundle=ResourceBundle.getBundle("test");



	public RequestSpecification getURI(String baseURI)
	{
		return given().baseUri(baseURI);

	}
	
	public String readFile(String file) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
				// System.out.println(sCurrentLine);
				sb.append(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return sb.toString();
	}

}
