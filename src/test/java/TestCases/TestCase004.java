package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class TestCase004 {

	Map<Object, Object> map = new HashMap<Object, Object>();

	@BeforeClass

	public void setUp() {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/update";
		RestAssured.basePath = "/21";
		map.put("name", "Tanmoy");
		map.put("salary", "5000");
		map.put("age", "20");

	}
	@Test

	public void validatePut() {

		given()
		.contentType("application/json")
		.body(map)
		.when()
		.put()
		.then()
		.statusCode(200)
		.contentType("application/json");
  }
}
