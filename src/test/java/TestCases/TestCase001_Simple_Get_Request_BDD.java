package TestCases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestCase001_Simple_Get_Request_BDD extends TestBase{
	
	@BeforeClass
	
	public void setUp() {
	
	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weatherfull/city";
	RestAssured.basePath="/hyderabad";
	
	}

	@Test

	public void validateGet() {
		
		logger.info("######TestCase001 Starts######");

		given()
		.when()
		.get()
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.body("City", equalTo("Hyderabad"))
		.body("size()", equalTo(6))
		.contentType("application/json")
		//.header("Content-Length","633")
		.header("Server","nginx");
		
		logger.info("######TestCase001 Ends######");

	}
	
	@Test

	public void validateEntireBody() {

		Response response = given()
		.when()
		.get();
		
		//response.header("Content-Length");
		
		String s = response.body().asString();
					
		System.out.println("Responses Body is" + s);

	}
	
	
}
