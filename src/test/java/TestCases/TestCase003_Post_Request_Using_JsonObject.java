package TestCases;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import Base.TestBase;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase003_Post_Request_Using_JsonObject extends TestBase {

	@BeforeClass

	public void setUp() {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/create";

	}

	@Test(priority = 3)

	public void validateResponseUsingJsonFile() throws FileNotFoundException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\JsonInputFile\\jsonrequest.json");
		Response response = given().contentType("application/json").body(fis).when().post();
		System.out.println("Response is" + response.body().asString());
	}

}
