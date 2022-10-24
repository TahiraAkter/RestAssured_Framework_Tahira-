package testPackage;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;

public class GetCall_reqres_users_test {
	
	@Test(enabled = false)
	public void printResponse() {
		RestAssured
		.when() 
			.get("https://reqres.in/api/users?page=1")
		.then()
			.extract()
			.response()
			.prettyPrint();
	}

	@Test(enabled = false)
	public void logRequestResponse() {
		RestAssured
		.given()
			.log().all()
		.when()
			.get("https://reqres.in/api/users?page=1")
		.then().log().all();

	}

	@Test(enabled = false)
	public void assertStatusCode() {
		RestAssured
		.when()
			.get("https://reqres.in/api/users?page=1")
		.then()
			.assertThat()
			.statusCode(200);
	}

	@Test(enabled = false)
	public void assertBody() {
		RestAssured
		.when()
			.get("https://reqres.in/api/users?page=1")
		.then().log().all()
			.assertThat()
			.body("data.id", hasSize(6))
			.body("data.email", hasSize(6))
			.body("data.first_name", hasSize(6))
			.body("data.last_name", hasSize(6));
	}
	@Test(enabled = false)
	public void assertContentType() {
		RestAssured
		.when()
		.get("https://reqres.in/api/users?page=1")
		.then()
		.contentType(ContentType.JSON);
	}

	@Test(enabled = true)
	public void assertHeader() {
		RestAssured
		.when()
			.get("https://reqres.in/api/users?page=1")
		.then()
			.assertThat().header("Cache-Control", equalTo("max-age=14400"));
	}
	@Test(enabled = false)
	public void printHeaders() {
		Headers headers =
		RestAssured
		.when()
		.get("https://reqres.in/api/users?page=1")
		.then()
		.extract().headers();
		
		System.out.println(headers.toString());
	}
	
	@Test(enabled = false)
	public void printHeader() {
		String header =
		RestAssured
		.when()
		.get("https://reqres.in/api/users?page=1")
		.then()
		.extract()
		.header("CF-RAY");
		
		System.out.println(header);
	}
}
