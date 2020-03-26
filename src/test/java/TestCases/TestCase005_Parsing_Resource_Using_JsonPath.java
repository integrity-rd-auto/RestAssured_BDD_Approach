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


public class TestCase005_Parsing_Resource_Using_JsonPath extends TestBase{
	
	
	Response response=null; 
	@BeforeClass
	
	public void setUp() {
	
	RestAssured.baseURI="https://swapi.co/api";
	RestAssured.basePath="/people";	
	}
	
	@Test
	public void headValidation() {
		
		response= given()
		.when()
		.options();
		
		System.out.println("Options are"+ response);				
		Assert.assertEquals(response.statusCode(), 200);		
	}
		
	@Test
	public void validateSpecificBody() {
		given()
		.when()
		.get()
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.body("count", is(87));
	}
	@Test
	public void validate2() {
		given()
		.when()
		.get()
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.body("results.name[0]", equalTo("Luke Skywalker"));		
	}
	
	@Test
	public void validate3() {
		given()
		.when()
		.get()
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.body("results.films[0][0]", equalTo("https://swapi.co/api/films/2/"));
		
	}
	
	@Test
	public void validate4() {
		response=given().when().get();
			
		Assert.assertTrue(response.getTime()<=3000);
		
		String json = response.getBody().asString();
		
		System.out.println(json);
		
		JsonPath jsonPath = new JsonPath(json);
		
		 Assert.assertEquals(
		            "C-3PO",
		            jsonPath.getString("results.name[1]"));
		 
		 Assert.assertEquals(
		            "white, blue",
		            jsonPath.getString("results.skin_color[2]"));		
	}
	
	
}
