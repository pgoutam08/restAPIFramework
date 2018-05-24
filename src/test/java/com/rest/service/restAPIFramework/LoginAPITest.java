package com.rest.service.restAPIFramework;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import responsepojo.LoginResponse;

public class LoginAPITest extends TestBase{

	String username;
	String password;
	String trn;
	String crmId;
	
	@BeforeClass
	public void dataSetUp()
	{
		username = "tim";
		password = "password1##";
		trn = "100336302";
		crmId = "100008596";
		
	}
	
	@Test
	public void loginAPITest()
	{
		service = new Service();
		
		response = service.loginAPI(username, password);
		
		if(response.getStatusCode() == 200)
		{
			System.out.println(response.asString());
			
			Gson gson = new Gson();
			LoginResponse loginResponse = gson.fromJson(response.asString(), LoginResponse.class);
			
						
			Assert.assertEquals(loginResponse.getUsername(), username);
			Assert.assertEquals(loginResponse.getTrn(), trn);
			Assert.assertEquals(loginResponse.getCrmId(), crmId);
			
		}
		else
		{
			Assert.assertTrue(false, response.asString());
						
		}
	}
	
	
}
