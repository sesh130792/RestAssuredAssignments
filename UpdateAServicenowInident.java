package allweek.prac;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateAServicenowInident {
	
	String uri = "https://dev76355.service-now.com/api/now/table/incident/529fae402f5221103c99f64ef699b694";
	
	@Test
	public void updateAnIncidentUsingPut() {
		RestAssured.baseURI = uri;
		RestAssured.authentication = RestAssured.basic("admin", "WzNq$5@9JMcs");
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"short_description\": \"updated string using put\",\r\n"
				+ "    \"description\": \"updated string using put\"\r\n"
				+ "}");
		Response putResponse = inputRequest.put();
		putResponse.prettyPrint();
	}
	
	@Test
	public void updateAnIncidentUsingPatch() {
		RestAssured.baseURI = uri;
		RestAssured.authentication = RestAssured.basic("admin", "WzNq$5@9JMcs");
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"short_description\": \"patch\",\r\n"
				+ "    \"description\": \"updated string using patch\"\r\n"
				+ "}");
		Response putResponse = inputRequest.patch();
		putResponse.prettyPrint();
	}
	
	@Test
	public void deleteAnIncident() {
		RestAssured.baseURI = uri;
		RestAssured.authentication = RestAssured.basic("admin", "WzNq$5@9JMcs");
		Response deleteResponse = RestAssured.delete();
		deleteResponse.prettyPrint();
	}
}
