package com.queryandpath;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class CookieTest {

	@Test(priority=1)
	void cookiesTest() 
	{
	
		given()
		
		.when().get("https://google.com/")
		
		.then().cookie("AEC", "uiouofkUUIOcsncm,").log().all();
		
	}
	
	@Test(priority=2)
	void getCookie() 
	{
	
		Response res = given()
		
		.when().get("https://google.com/");
		
		String s = res.getCookie("AEC");
		System.out.println("Cookie is: " + s);
	}
	
	@Test(priority=3)
	void getAllCookies() 
	{
	
		Response res = given()
		
		.when().get("https://google.com/");
		
		Map<String, String> map = res.getCookies();
		//System.out.println("Cookies is: " + map.keySet());
		for(String temp :map.keySet())
		{
			String s = res.getCookie(temp);
			System.out.println("Cookie name: " + temp + " Value is: " + s);
		}
	}
}
