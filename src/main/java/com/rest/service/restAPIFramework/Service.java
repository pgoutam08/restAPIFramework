package com.rest.service.restAPIFramework;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import requestpojo.Login;
import responsepojo.LoginResponse;




public class Service {
		
	public Response loginAPI(String username, String password)
	{
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		
		
		JSONObject jsonObj = new JSONObject(login);
		
		System.out.println("JSON Payload");
		
		System.out.println(jsonObj);
		
		RequestSpecification reqSpecification = RestAssured.given();
		reqSpecification.contentType("application/json");
		reqSpecification.accept("application/json");
		
		
		reqSpecification.body(jsonObj.toString());
		System.out.println("End Point URI is : "+ServiceURL.loginURL);
		Response response =  reqSpecification.post(ServiceURL.loginURL);
	
		return response;
		
		
	}
	
	
	public static void main(String[] args)
	{
	
		
		
		Service service = new Service();
		
		Response data = service.loginAPI("tim", "password1##");
		
		if(data.getStatusCode() == 200)
		{
		
			System.out.println(data.asString());
			
			Gson gson = new Gson();
			
			LoginResponse loginResponse = gson.fromJson(data.asString(), LoginResponse.class);
			
			System.out.println(loginResponse.getUsername());
			System.out.println(loginResponse.getTrn());
			System.out.println(loginResponse.getCrmId());
			
			Assert.assertEquals(loginResponse.getUsername(), "tim");
			Assert.assertEquals(loginResponse.getTrn(), "100336302");
			Assert.assertEquals(loginResponse.getCrmId(), "100008596");
		
		}	
	}

}
