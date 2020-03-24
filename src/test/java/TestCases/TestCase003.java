package TestCases;
import org.testng.annotations.Test;

import Base.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase003 extends TestBase{

	// HashMap map = new HashMap();
	Map<Object, Object> map = new HashMap<Object, Object>();

	@BeforeClass

	public void setUp() {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/create";
		map.put("name", "Tanmoy");
		map.put("salary", "5000");
		map.put("age", "20");

	}

	@Test(priority=1)

	public void validatePost() {
		logger.info("######validatePost() Starts######");
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.post()
		.then()
		.statusCode(200)
		.contentType("application/json");
  }
	
	@Test(priority=2)

	public void validateResponse() {

		Response response = given()
		.contentType("application/json")
		.body(map)
		.when()
		.post()
		;		
		System.out.println("Response is"+response.body().asString());
  }

}
