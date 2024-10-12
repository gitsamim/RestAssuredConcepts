package com.authentication;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentication {

	@Test(priority=1)
	void testBasicAuth() 
	{
		given().auth().basic("postman", "password")
		
		.when().get("https://postman-echo.com/basic-auth")
		
		.then().statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	@Test(priority=2)
	void testPreemptie() 
	{
		given().auth().preemptive().basic("postman", "password")
		
		.when().get("https://postman-echo.com/basic-auth")
		
		.then().statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	@Test(priority=3)
	void testDigest() 
	{
		given().auth().digest("postman", "password")
		
		.when().get("https://postman-echo.com/basic-auth")
		
		.then().statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	@Test(priority=4)
	void testBearer() 
	{
		String bearerTocken = "ghhjkTYGghbnvnUYIUYIUYERloij";
		
		given().headers("Authorization","Bearer "+bearerTocken)
		
		.when().get("https://postman-echo.com/basic-auth")
		
		.then().statusCode(200)
		.log().all();
	}
	
	@Test(priority=5)
	void testOAuthAuthentication() 
	{
		given().auth()
		.oauth("consumerKey", "consumerSecret", "accessToken", "tockenSecret")
		
		.when().get("https://postman-echo.com/basic-auth")
		
		.then().statusCode(200)
		.log().all();
	}
	
	@Test(priority=6)
	void testOAuth2Authentication() 
	{
		given().auth()
		.oauth2("ghhjkTYGghbnvnUYIUYIUYERloij")
		
		.when().get("https://postman-echo.com/basic-auth")
		
		.then().statusCode(200)
		.log().all();
	}
}
