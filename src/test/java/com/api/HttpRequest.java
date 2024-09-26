package com.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
	given() -content type, set cookies, add auth, add param, set headers info ...
	
	when() -get, post, delete, put, patch
	
	then() -validate status code, extract response, extract header, cookies, response body
 
 
 */
public class HttpRequest {

	int id=0;
	//@Test
	void getUsers()
	{
		given()
		
		.when().get("https://reqres.in/api/users?page=2")
		
		.then().statusCode(200).body("page", equalTo(8)).log().all();
	}
	
	@Test(priority=2)
	void createUsers()
	{
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "samim");
		data.put("job", "testing");
		
		id=given().contentType("application/json").body(data)
		
		.when().post("https://reqres.in/api/users").jsonPath().getInt("id");
		
		// .then().statusCode(200).log().all();
		
		System.out.println("ID IS: " + id); 
	}
	
	@Test(priority=3, dependsOnMethods= {"createUsers"})
	void updateUsers()
	{
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "sabir");
		data.put("job", "developer");
		
		given().contentType("application/json").body(data)
		
		.when().put("https://reqres.in/api/users/"+id)
		
		 .then().statusCode(200).log().all();
		
	}
}
