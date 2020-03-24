package TestCases;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Base.TestBase;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class TestCase002 extends TestBase {

	@Test

	public void postValidation() {
		logger.info("######TestCase002 Starts######");

		RequestSpecification request = RestAssured.given();
		request.baseUri("http://restapi.demoqa.com/utilities/weatherfull/city/");
		request.basePath("hyderabad");

		Response response = null;

		response = request.get();

		System.out.println(response.asString());
	}
}
