package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class TestCase004_Post_Request_Using_Param {

	Map<Object, Object> map = new HashMap<Object, Object>();

	@BeforeClass

	public void setUp() {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/update";
		RestAssured.basePath = "/21";
		}
		
	@Test

	public void validatePutUsingParams() {

		given()
		.param("name", "Aaru")
	    .param("salary", "1000")
	    .param("age", "12")
		.contentType("application/json")
		.when()
		.put()
		.then()
		.statusCode(200)
		.contentType("application/json");
  }
}
