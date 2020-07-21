package com.Doglist;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC_03Subbreeds {

	@Test
	public void getsubbreed() {
		
		RestAssured.baseURI ="https://dog.ceo/api/breed/retriever/list"; 
		RequestSpecification request = RestAssured.given();


		               
		Response response=request.get();
				ResponseBody body=response.getBody();
				String bodyString=body.asString();
				System.out.println("Response body:"+bodyString);
	}
	
}
		
	
	
	

