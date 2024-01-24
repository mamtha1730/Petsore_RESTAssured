package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Userendpoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class DDTests 
{
	@Test(priority=1, dataProvider="data",dataProviderClass=Dataproviders.class)
	public void testpostuser(String userid,String username,String firstname,String lastname,String email,String password,String phone)
	{
		User userpayload=new User();
		
		userpayload.setId(Integer.parseInt(userid));
		userpayload.setUsername(username);
		userpayload.setFirstname(firstname);
		userpayload.setLastname(lastname);
		userpayload.setPassword(password);
		userpayload.setPhone(phone);
		
		Response response=Userendpoints.createuser(userpayload);
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=2,dataProvider="usernames",dataProviderClass=Dataproviders.class)
	public void testdeleteuserbyname(String username)
	{
		Response response=Userendpoints.deleteuser(username);
		Assert.assertEquals(response.getStatusCode(),200);
	}
}
