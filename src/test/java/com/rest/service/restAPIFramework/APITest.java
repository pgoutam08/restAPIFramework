package com.rest.service.restAPIFramework;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jayway.restassured.response.Headers;

import responsepojo.GetBodyType;
import responsepojo.GetProfileResponse;
import responsepojo.Loan;
import responsepojo.LoginResponse;


public class APITest extends TestBase{

	String username;
	String password;
	String trn;
	String crmId;
	String loanId;
	String loanPath;
	String loanStatus;
	
	
	@BeforeClass
	public void dataSetUp()
	{
		username = "bhiggins";
		password = "password1##";
		trn = "105717827";
		crmId = "100006115";
		
		testData = new ArrayList<Object>();
		testData.add("Sedan");
		testData.add("Coupe");
		testData.add("SUV");
		testData.add("Truck");
		testData.add("Hatchback");
		testData.add("Convertible");
		
		loanId = "1";
		
		loanPath = "/api/v1/loans/";
		loanStatus = "DRAFT";
	}
	
		
	@Test(priority=1)
	public void loginAPITest()
	{
		
		
		
		service = new Service();
		
		response = service.loginAPI(username, password);
		
		
		if(response.getStatusCode() == 200)
		{
							
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
	
	
	List<Object> list;
	List<Object> testData;
	
	
	
	@Test(priority=2)
	public void getBodyTypeAPITest()
	{
		
		service = new Service();
				
		response = service.getBodyType();
		
				
		if(response.getStatusCode()==200)
		{
			
			Gson gson = new Gson();
			
			GetBodyType[] bodyData = gson.fromJson(response.asString(), GetBodyType[].class);
			Headers headers = response.headers();
			System.out.println(headers.size());
			
			list = new ArrayList<Object>();
			for(int i = 0; i<bodyData.length;i++)
			{
				//System.out.println(bodyData[i].getValue());
				list.add(bodyData[i].getValue());
				
			}
			Assert.assertEquals(list, testData);
		}
		else
		{
			Assert.assertTrue(false, response.asString());
			
			System.out.println("Check Response");
		}

	}
	
	@Test(priority=3)
	public void getProfilesAPITest()
	{
		service = new Service();
		
		response = service.getProfiles(username);
		
			
		if(response.getStatusCode()==200)
		{
			
			Gson gson = new Gson();
			
			GetProfileResponse getProfile = gson.fromJson(response.asString(), GetProfileResponse.class);
			
			List<Loan> loans = getProfile.getLoans();
			list = new ArrayList<Object>();
			
			Assert.assertEquals(getProfile.getUsername(), username);
			Assert.assertEquals(getProfile.getCrmId(), crmId);
			
			for(int i=0;i<loans.size();i++)
				{
					
					//System.out.println(loans.get(i).getLoanId());
					//Assert.assertEquals(loans.get(i).getLoanId(), loanId);
				//System.out.println((loans.get(i).getClass().equals(String.class)));
					Assert.assertEquals(loans.get(i).getLoanPath(), loanPath+(i+1));
					Assert.assertEquals(loans.get(i).getLoanStatus(), loanStatus);
									
				}
		}
		else
		{
			
			Assert.assertTrue(false, response.asString());
						
		}

	}
			
}
