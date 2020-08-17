package com.Doglist;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
public class TC_04Subreedimage {
	@Test
	public void Test_04() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\azv2311\\Desktop\\Srilatha\\Selenium Files\\Assignment_RestAssured\\Config\\Data.properties");
		Properties prop = new Properties();
		prop.load(fis);
RestAssured.baseURI = prop.getProperty("baseURL");

        
        Response res = given().
                when().
                get(prop.getProperty("resouce_for_random_image")).
                then().
                assertThat().
                statusCode(200).and().
                contentType(ContentType.JSON).and().extract().response();

       
        String responseString = res.asString();

        
        responseString = responseString.replace("\\", "");
		
	System.out.println( responseString);	
}
}