package com.Doglist;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


	public class TC_01Doglist {

		@Test
		void getDogbreed()
		{
			RestAssured.baseURI="https://dog.ceo/api/breeds/list/all";
			 //Request object
			  RequestSpecification httpRequest=RestAssured.given();
	          Response response=httpRequest.request(Method.GET,"");
	
	String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  
	  
	
	int statusCode=response.getStatusCode();
	System.out.println("Status code is:"+statusCode);
	AssertJUnit.assertEquals(statusCode, 200);
	
	 //status line verification
	  String statusLine=response.getStatusLine();
	  System.out.println("Status line is:"+statusLine);
	  AssertJUnit.assertEquals(statusLine, "HTTP/1.1 200 OK");
	
		}
		
	}

