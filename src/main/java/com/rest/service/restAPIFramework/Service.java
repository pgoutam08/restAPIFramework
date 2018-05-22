package com.rest.service.restAPIFramework;

import org.json.JSONObject;

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
		
		RequestSpecification reqSpecification = RestAssured.given();
		reqSpecification.contentType("application/json");
		reqSpecification.accept("application/json");
		
		JSONObject jsonObj = new JSONObject(login);
		reqSpecification.body(jsonObj);
		
		Response response =  reqSpecification.post(ServiceURL.loginURL);
		return response;
		
		
	}
	
	
	public static void main(String[] args)
	{
		Service service = new Service();
		
		Response data = service.loginAPI("tim", "password1##");
		
		System.out.println(data.asString());
	//	Gson gson = new Gson();
		
	//	gson.fromJson(data.asString(), Login.class);
		
		LoginResponse loginResponse = new LoginResponse();
		
		System.out.println(loginResponse.getUsername());
		System.out.println(loginResponse.getTrn());
		System.out.println(loginResponse.getCrmId());
		
		
		
		
	}

}
