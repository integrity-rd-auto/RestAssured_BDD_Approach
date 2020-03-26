package TestCases;
import org.testng.annotations.Test;

import Base.TestBase;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class TestCase007_Post_Request_Using_Serialization_of_POJO_into_JSON_Request_Body_Object extends TestBase{
	@BeforeClass

	public void setUp() {

		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath = "/posts";
		
		}

	@Test(priority=1)

	public void validatePost() {
		
		JSONObject json = new JSONObject();
		json.put("id", 133);
		json.put("title", "json-server4");
		json.put("author", "typicode4");
		logger.info("######validatePost() Starts######");
		Response response = 
		given()
		.contentType("application/json")
		.body(json.toJSONString())
		.when()
		.post();
		
		System.out.println(response.asString());
		
  }	
@Test	
public void validatePost1() {
		
		JsonInputData2 jsoninput = new JsonInputData2();
		logger.info("######validatePost() Starts######");
		Response response = 
		given()
		.contentType("application/json")
		.body(jsoninput)
		.when()
		.post();
		
		System.out.println(response.asString());
		
  }	

}
