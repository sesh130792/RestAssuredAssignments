package week3.day2.basesetup;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CreateIncident extends BaseClass{
	
	@Test
	public void createIncident() {
		response = request.post("incident");
		sys_id = response.jsonPath().get("result.sys_id");
		System.out.println(sys_id);
		response.then().assertThat().statusCode(201);
	}
	
	

}
