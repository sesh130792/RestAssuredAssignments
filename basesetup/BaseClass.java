package week3.day2.basesetup;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	String uri = "https://dev76355.service-now.com/api/now/table/";
	static RequestSpecification request = null;
	static Response response = null;
	static String sys_id = null;

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = uri;
		RestAssured.authentication = RestAssured.basic("admin", "WzNq$5@9JMcs");
		request = RestAssured.given().contentType(ContentType.JSON);
	}

	@AfterMethod
	public void tearDown() {
		response.then().log().all();
	}
}
