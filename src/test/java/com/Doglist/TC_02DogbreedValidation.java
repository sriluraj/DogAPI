package com.Doglist;

import javax.print.Doc;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC_02DogbreedValidation {

	@Test
    public void queryParameter() {

RestAssured.baseURI ="https://dog.ceo/api/breeds/list/all"; 
RequestSpecification request = RestAssured.given();


               
Response response=request.get();
		ResponseBody body=response.getBody();
		String bodyString=body.asString();
		System.out.println("Response body:"+bodyString);
		Assert.assertEquals(bodyString.contains("retriever") /*Expected value*/, true /*Actual Value*/, "Response body contains retriever");
	//	System.out.println("Response body:"+response.body().asString());*/
	}
	
}

	
	

