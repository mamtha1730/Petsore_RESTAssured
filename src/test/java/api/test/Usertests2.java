package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class Usertests2
{
	Faker faker;
	User userpayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		faker=new Faker();
		userpayload= new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger=LogManager.getLogger(this.getClass());
		
		logger.debug("Debugging...");
	}
	
	@Test(priority=1)
	public void testpostuser()
	{
		logger.info("******Creating User **********");
		Response response=Userendpoints2.createuser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("******User has been created **********");
	}
	
	@Test(priority=2)
	public void testgetuser()
	{
		logger.info("******Reading  User Info**********");
		Response response=Userendpoints2.readuser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("****** User Info is displayed **********");
	}
	
	@Test(priority=3)
	public void testupdateuser()
	{
		//update data using payload
		logger.info("******Updating User **********");
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		
		
		
		Response response=Userendpoints2.updateuser(this.userpayload.getUsername(), userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		Response responseafterupdate=Userendpoints2.readuser(this.userpayload.getUsername());
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
		logger.info("******User Info is updated **********");
	}
	
	@Test(priority=4)
	public void testdeleteuser()
	{
		logger.info("******Deleting User **********");
		Response response=Userendpoints2.deleteuser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("******User is deleted **********");
	}
	
}
