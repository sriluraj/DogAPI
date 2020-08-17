package com.Doglist;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC_02DogbreedValidation {

	@Test
    public void queryParameter() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\azv2311\\Desktop\\Srilatha\\Selenium Files\\Assignment_RestAssured\\Config\\Data.properties");
		Properties prop = new Properties();
		prop.load(fis);

//Base URL
RestAssured.baseURI = prop.getProperty("baseURL");

Response res = given().
when().
get(prop.getProperty("resources")).
then().
assertThat().
statusCode(200).and().
contentType(ContentType.JSON).and().extract().response();
String responseString = res.asString();
JsonPath js = new JsonPath(responseString);

if (responseString.contains("retriever")) {

    System.out.println("Verify retriver is withinList :");
    System.out.println("String Response"+responseString);
} else
	 System.out.println("Verify retriver is not inList :");
}

}	
	

