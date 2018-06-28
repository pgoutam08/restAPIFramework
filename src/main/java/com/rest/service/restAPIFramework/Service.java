package com.rest.service.restAPIFramework;

import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import requestpojo.Login;
import responsepojo.LoginResponse;




public class Service{
	
	public static String token;
	
		
	public static Response loginAPI(String username, String password)
	{
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		
		
		JSONObject jsonObj = new JSONObject(login);
		
		RequestSpecification reqSpecification = RestAssured.given();
		reqSpecification.contentType("application/json");
		reqSpecification.accept("application/json");
		reqSpecification.body(jsonObj.toString());
			
		
		Response response =  reqSpecification.post(ServiceURL.baseURL+ServiceURL.login);
		
		token = response.getHeader("Token").toString();
		
		/*//retrieve token from response header for authentication in other APIs;
		public String getToken()
		{
			return token;
			
		}
		
		public void setToken()
		{
			token = strToken;
		}*/
				
		return response;
		
		
	}
	
	private static void getToken() {
		// TODO Auto-generated method stub
		
	}

	public static Response getBodyType()
	{
		
		
	
		JSONObject jsonObj = new JSONObject();
		//System.out.println(token);
		RequestSpecification reqSpecification = RestAssured.given();
		reqSpecification.contentType("application/json");
		reqSpecification.accept("application/json");
		reqSpecification.header("Authorization", "Bearer "+token);
		reqSpecification.body(jsonObj.toString());
		//System.out.println(ServiceURL.baseURL+ServiceURL.bodyType);
		
		Response response = reqSpecification.get(ServiceURL.baseURL+ServiceURL.bodyType);
		
		//System.out.println(response.asString());
		return response;
		
	}
	
	
	public static Response getProfiles(String userName)
	{
		
		
	
		JSONObject jsonObj = new JSONObject();
		//System.out.println(token);
		RequestSpecification reqSpecification = RestAssured.given();
		reqSpecification.contentType("application/json");
		reqSpecification.accept("application/json");
		reqSpecification.header("Authorization", "Bearer "+token);
		reqSpecification.body(jsonObj.toString());
		//System.out.println(ServiceURL.baseURL+ServiceURL.bodyType);
		
		Response response = reqSpecification.get(ServiceURL.baseURL+ServiceURL.profile);
		
		//System.out.println(response.asString());
		return response;
		
	}
	
	

}
