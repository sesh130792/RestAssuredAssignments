package week3.day2.basesetup;

import org.testng.annotations.Test;

public class DeleteIncident extends BaseClass{
	
	@Test(dependsOnMethods  = {"week3.day2.basesetup.UpdateIncident.updateDescription"})
	public void deleteIncident() {
	response =	request.delete("incident/" + sys_id);
	System.out.println(response.statusLine());	
	response.then().assertThat().statusCode(204);
	}
}
