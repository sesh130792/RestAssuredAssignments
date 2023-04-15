package steps;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitions {

	String uri = "https://dev76355.service-now.com/api/now/table/incident";
	RequestSpecification inputRequest = null;
	Response response = null;

	@Given("Endpoint is set")
	public void setEndpoint() {
		RestAssured.baseURI = uri;
	}

	@And("Auth is added")
	public void authenticate() {
		RestAssured.authentication = RestAssured.basic("admin", "WzNq$5@9JMcs");
	}

	@When("Request is sent")
	public void sendRequest() {
		inputRequest = RestAssured.given().log().all();
		response = inputRequest.get();
	}

	@Then("Validate response")
	public void validateResponse() {
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
	}

	@When("Send request with query param {string} {string}")
	public void sendRequestWithQueryParam(String field, String value) {
		inputRequest = RestAssured.given().log().all().queryParam(field, value);
		response = inputRequest.get();
	}
	
	@When("Send request with query params")
	public void sendRequestWithQueryParams(DataTable dTable) {
		Map<String, String> queryParamValues = dTable.asMap();
		inputRequest = RestAssured.given().log().all().queryParams(queryParamValues);
		response = inputRequest.get();
	}
}
