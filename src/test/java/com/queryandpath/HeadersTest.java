package com.queryandpath;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersTest {

	//@Test(priority=1)
	void testHeader() 
	{
	
		given()
		
		.when().get("https://google.com/")
		
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Content-Encoding", "gzip")
		.header("Server", "gws");
	}
	
	//@Test(priority=2)
	void getHeader() 
	{
	
		Response res = given()
		
		.when().get("https://google.com/");
		
		String s = res.getHeader("Content-Type");
		System.out.println("Content-Type IS: " + s);
	}
	
	@Test(priority=3)
	void getAllHeader() 
	{
	
		Response res = given()
		
		.when().get("https://google.com/");
		
		Headers headers = res.getHeaders();
		for(Header temp : headers)
		{
			System.out.println("Name is: " + temp.getName());
			System.out.println("Value is: " + temp.getValue());
		}
	}
}
