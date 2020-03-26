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


public class TestCase006_Parsing_Using_JsonPath_Complex_Resource extends TestBase{
		
	Response response=null; 
	@BeforeClass	
	public void setUp() {
	
	RestAssured.baseURI="https://swapi.co/api/people";
	RestAssured.basePath="/2";
	}
	
	@Test
	public void validateSpecificBody() {
		given()
		.when()
		.get()
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.body("mass", equalTo("75"));
	}
	
	
	@Test
	public void validate4() {
		response=given().when().get();
		
		String json = response.getBody().asString();
		
		System.out.println(json);
		
		JsonPath jsonPath = new JsonPath(json);
		
		 Assert.assertEquals(
		            "C-3PO",
		            jsonPath.getString("name"));
		 Assert.assertEquals(
		            "https://swapi.co/api/films/2/",
		            jsonPath.getString("films[0]"));
		 
		 
		 	}
	
	
}
