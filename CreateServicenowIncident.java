package allweek.prac;

import java.io.File;

import org.apache.http.entity.mime.content.FileBody;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateServicenowIncident {
 /*
  * Requirement
  * Endpoint + Resource
  * Construct the request
  * Send the request
  * Valiate the request
  */
	// For post, content type is mandatory
	String uri = "https://dev76355.service-now.com/api/now/table/incident";
	File bodyFile = new File("./data.json");
	
	@Test
	public void createIncidentWithoutBody() {
		RestAssured.baseURI = uri;
		RestAssured.authentication = RestAssured.basic("admin", "WzNq$5@9JMcs");
		RequestSpecification inputRequest = RestAssured.given()
				.contentType(ContentType.JSON);
//				.contentType("application/json");
		Response response = inputRequest.post();
		response.prettyPrint(); 
	}
	
	@Test
	public void createIncidentWithBodyAsString() {
		RestAssured.baseURI = uri;
		RestAssured.authentication = RestAssured.basic("admin", "WzNq$5@9JMcs");
		RequestSpecification inputRequest = RestAssured.given()
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"short_description\": \"Windows box - 192.168.1.21 is not working - Sesh\",\r\n"
						+ "    \"description\": \"My windows box is not restarting - seems crashing all the time.\"\r\n"
						+ "}");
		Response response = inputRequest.post();
		response.prettyPrint(); 
	}
	
	@Test
	public void createIncidentWithBodyAsFile() {
		RestAssured.baseURI = uri;
		RestAssured.authentication = RestAssured.basic("admin", "WzNq$5@9JMcs");
		RequestSpecification inputRequest = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(bodyFile);
		Response response = inputRequest.post();
		response.prettyPrint(); 
	}
}
