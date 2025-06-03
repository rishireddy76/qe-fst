
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestAPI {
	static Long petId;
	 @Test
	    public void AddPetDetails() {
	        
	        String baseURI = "https://petstore.swagger.io/v2/pet";
	        String reqBody = "{\"name\": \"Simba\", \"status\": \"alive\" }";

		    Response response = 
		        given().contentType(ContentType.JSON) 
		        .body(reqBody).when().post(baseURI);
		    String body = response.getBody().asPrettyString();
		    System.out.println(body);
		    
		    petId = response.jsonPath().getLong("id");
		    System.out.println("Saved petId: " + petId);
	    }
		    
	 @Test
	 
	       public void UpdatePetStatus(){
		     String updateURI = "https://petstore.swagger.io/v2/pet";
		    
		     String update = "{ \"id\": " + petId + ", \"name\": \"Simba\", \"status\": \"sold\" }";
		     Response putResponse =given()
		                .contentType(ContentType.JSON)
		                .body(update)
		                .put(updateURI);
		     System.out.println("Update Response:\n" + putResponse.getBody().asPrettyString());
}
	 @Test(priority = 3)
	 public void GetPetById() {
	        String URI = "https://petstore.swagger.io/v2/pet/{petId}";

	        Response response = given()
	                .contentType(ContentType.JSON)
	                .when().pathParam("petId", petId).get(URI);
            
	        System.out.println(response.prettyPrint());
	        String petstatuss = response.then().extract().path("status");
            System.out.println(petstatuss);
	        }
	 
	 @Test(priority = 4)
	 public void DeletePetById() {
		 String deleteURI = "https://petstore.swagger.io/v2/pet/" + petId;
		 Response deleteResponse = given()
		            .contentType(ContentType.JSON)
		            .delete(deleteURI);

		    System.out.println("Delete Response:\n" + deleteResponse.asPrettyString());
		    deleteResponse.then().statusCode(200);
	 }
}
	 
