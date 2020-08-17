package com.Doglist;


import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
public class TC_03Subbreeds {
	

	@Test
public void Test_03() throws IOException {
		
		
		FileInputStream fis = new FileInputStream("C:\\Users\\azv2311\\Desktop\\Srilatha\\Selenium Files\\Assignment_RestAssured\\Config\\Data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		RestAssured.baseURI = prop.getProperty("baseURL");

	     //To get the Retriver breed  
        Response res = given().
                when().
                get(prop.getProperty("resources_for_retriver_breed")).
                then().
                assertThat().
                statusCode(200).and().
                contentType(ContentType.JSON).and().extract().response();
        String responseString = res.asString();
        System.out.println(responseString);
		//To Save the out put in a file
				File file = new File("C:\\Users\\azv2311\\Desktop\\Srilatha\\Selenium Files\\Assignment_RestAssured\\TestResults\\Assignment3.txt");
				FileWriter f = new FileWriter(file);
				f.write(responseString);
				f.close();
				
	}
	
}
		
	
	
	

