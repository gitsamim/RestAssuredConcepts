package com.queryandpath;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParam {

	@Test()
	void QueryAndPathParam() 
	{
	
		given().pathParam("mypath", "users")
		.queryParam("page", 2)
		
		.when().get("https://reqres.in/api/{mypath}")
		
		.then().statusCode(200).log().all();
		
	}
}
