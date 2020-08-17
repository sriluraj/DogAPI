package com.Doglist;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.AssertJUnit;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


	public class TC_01Doglist {
		 
		
		
		
		@Test
		public void GetList() throws IOException {
			
			//Reading the URL from Properties file
			FileInputStream fis = new FileInputStream("C:\\Users\\azv2311\\Desktop\\Srilatha\\Selenium Files\\Assignment_RestAssured\\Config\\Data.properties");
			Properties prop = new Properties();
			prop.load(fis);
			RestAssured.baseURI = prop.getProperty("baseURL");
			Response res = given().
	                when().
	                get(prop.getProperty("resources")).
	                then().
	                assertThat().
	                statusCode(200).and().
	                contentType(ContentType.JSON).and().extract().response();
			String responseString = res.asString();
			//Writing the output in the Folder Test Results
			File file = new File("C:\\Users\\azv2311\\Desktop\\Srilatha\\Selenium Files\\Assignment_RestAssured\\TestResults\\Assignment1.txt");
			FileWriter f = new FileWriter(file);
			f.write(responseString);
			f.close();
	     
	        
	      
	
		}
		
	}

