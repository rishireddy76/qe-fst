import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
public class Activity2 {
	String ROOT_URI = "http://ip-api.com/json/{ipAddress}";
	@Test
	public void getIPInformation() {
		Response response = 
				given().contentType(ContentType.JSON)
				.when().pathParam("ipAddress", "107.218.134.107")
				.get(ROOT_URI);
		
		System.out.println(response.getBody().asPrettyString());
	}
	
	
	final static String NEW_URI = "http://ip-api.com/json";
	 
	@Test
	public void getIPInformation2() {
	    Response response = 
	        given().contentType(ContentType.JSON) // Set headers
	        // Add query parameter
	        .when().queryParam("fields", "query,country,city,timezone")
	        .get(NEW_URI + "/125.219.5.94"); // Send GET request
	    
	    // Print response
	    System.out.println(response.getBody().asPrettyString());
	}
	// Set Base URL
}

