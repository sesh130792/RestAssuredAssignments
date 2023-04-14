package allweek.prac;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetServicenowIncidents {
	
	String uri = "https://dev76355.service-now.com/api/now/table/incident";
	Map<String, String> queryParams = new HashMap<String, String>();
	
	/*
	 * Requirement, Endpoint + Resource, Construct the request, Send the request
	 * Validate the response
	 */

	@Test
	public void getAllIncidents() {
		RestAssured.baseURI = uri; // endpoint + resource
		RestAssured.authentication = RestAssured.basic("admin", "WzNq$5@9JMcs"); // authentication
		Response getResponse = RestAssured.get(); // send the request
		getResponse.prettyPrint();
	}
	
	@Test
	public void getAllIncidentsWithQueryparams() {
		RestAssured.baseURI = uri;
		RestAssured.authentication = RestAssured.basic("admin", "WzNq$5@9JMcs");
		RequestSpecification inputRequest = RestAssured.given()
														.queryParam("sysparm_fields", "number, category")
														.queryParam("category", "software");
		Response response = inputRequest.get();
		response.prettyPrint();
	}
	
	@Test
	public void getAllIncidentsWithMulQueryparams() {
		RestAssured.baseURI = uri;
		RestAssured.authentication = RestAssured.basic("admin", "WzNq$5@9JMcs");
		queryParams.put("sysparm_fields", "number, category");
		queryParams.put("category", "software");
		RequestSpecification inputRequest = RestAssured.given()
														.queryParams(queryParams);
		Response response = inputRequest.get();
		response.prettyPrint();
	}
}
