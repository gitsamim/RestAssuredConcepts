package com.parsejson;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParseJSONResponse {

	//@Test(priority=1)
	void parseResponse1() 
	{
	
		given().contentType(ContentType.JSON)
		
		.when().get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("data[4].first_name", equalTo("George"));
	}
	
	//@Test(priority=2)
	void parseResponse2() 
	{
	
		Response res = given()
		
		.when().get("https://reqres.in/api/users?page=2");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		String fName = res.jsonPath().get("data[4].first_name").toString();
		Assert.assertEquals(fName, "George");
	}
	
	@Test(priority=3)
	void getLastName() 
	{
	
		Response res = given().contentType(ContentType.JSON)
		
		.when().get("https://reqres.in/api/users?page=2");
		
		JSONObject jo = new JSONObject(res.asString());
		for(int i=0; i<jo.getJSONArray("data").length(); i++)
		{
			String lName = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
			System.out.println(lName);
		}
	}
}
