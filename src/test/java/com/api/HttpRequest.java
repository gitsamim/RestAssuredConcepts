package com.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
	given() -content type, set cookies, add auth, add param, set headers info ...
	
	when() -get, post, delete, put, patch
	
	then() -validate status code, extract response, extract header, cookies, response body
 
 
 */
public class HttpRequest {

	@Test
	void getUsers()
	{
		given()
		
		.when().get("https://reqres.in/api/users?page=2")
		
		.then().statusCode(200).body("page", equalTo(8)).log().all();
	}
}
