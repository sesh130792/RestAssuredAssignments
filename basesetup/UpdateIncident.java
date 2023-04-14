package week3.day2.basesetup;

import org.testng.annotations.Test;

public class UpdateIncident extends BaseClass{
	
	@Test(dependsOnMethods  = {"week3.day2.basesetup.CreateIncident.createIncident"})
	public void updateDescription() {
		request.body("{\r\n"
						+ "    \"short_description\": \"test\",\r\n"
						+ "    \"description\": \"test\"\r\n"
						+ "}");
		response = request.put("incident/" + sys_id);
		response.then().assertThat().statusCode(200);	
	}
}
