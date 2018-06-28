package com.rest.service.restAPIFramework;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import responsepojo.GetBodyType;
import responsepojo.GetBodyTypeResponse;

public class GetBodyTypeAPITest extends APITest{

	
	List<Object> list;
	List<Object> testData;
	
	
	@BeforeClass
	public void dataSetUp() {
		testData = new ArrayList<Object>();
		testData.add("Sedan");
		testData.add("Coupe");
		testData.add("SUV");
		testData.add("Truck");
		testData.add("Hatchback");
		testData.add("Convertible");
		//String newToken = 
		
		
	}
	
	
	
	@Test
	public void getBodyTypeAPITest()
	{
		
		
		service = new Service();
		System.out.println("In GETBODYTYPE API: "+TestBase.token);
		
		response = service.getBodyType();
		
		System.out.println(response.asString());
		
		if(response.getStatusCode()==200)
		{
			
		
			Gson gson = new Gson();
			
			
			GetBodyType[] bodyData = gson.fromJson(response.asString(), GetBodyType[].class);
			
			list = new ArrayList<Object>();
			for(int i = 0; i<bodyData.length;i++)
			{
				System.out.println(bodyData[i].getValue());
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

	
}
