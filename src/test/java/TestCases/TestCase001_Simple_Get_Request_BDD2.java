package TestCases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestCase001_Simple_Get_Request_BDD2 extends TestBase{
	
	@BeforeClass
	
	public void setUp() {
	
	RestAssured.baseURI="https://postman-echo.com";
	RestAssured.basePath="/get";
	
	}

	@Test
	public void validateGet_Using_Response_and_JSONPATH() {
		
		logger.info("######TestCase001 Starts######");

		Response response = given()
		.when()
		.get();		
		
		String json = response.getBody().asString();
		
		JsonPath jsonPath = new JsonPath(json);
		
		Assert.assertEquals("https",jsonPath.getString("headers.x-forwarded-proto"));	
		
		System.out.println(json);
		
		logger.info("######TestCase001 Ends######");

	}
	@Test
	public void validateGet_Using_Body() {
		
		logger.info("######TestCase001 Starts######");

		given()
		.when()
		.get()
		.then()
		.assertThat()
		.body("headers.x-forwarded-proto",equalTo("https"))
		.body("args.empID",is(100));
		logger.info("######TestCase001 Ends######");

	}	
	
}
