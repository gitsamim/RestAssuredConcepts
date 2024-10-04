package com.json.schema;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SchemaValidation {

	@Test(priority=1)
	void jsonSchemaValidation() 
	{
	
		given()
		
		.when().get("https://reqres.in/api/users/")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"));
		
	}
}
