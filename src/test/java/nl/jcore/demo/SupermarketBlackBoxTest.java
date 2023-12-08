package nl.jcore.demo;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SupermarketBlackBoxTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Sql("/testdata.sql")
	void getSupermarket() throws Exception {
		//get data through api
		final var supermarket = getAuthenticatedRestTemplate()
				.getForObject("http://localhost:" + port + "/supermarket/1",
				String.class);

		assertEquals("supername", JsonPath.parse(supermarket).read("$.name"));
		assertEquals(1, JsonPath.parse(supermarket).read("$.id", Long.class));
	}

	private TestRestTemplate getAuthenticatedRestTemplate(){
		return restTemplate.withBasicAuth("user", "password");
	}

	@Test
	@Sql("/testdata.sql")
	void getSupermarketRestAssured() throws Exception {
		getAuthorizedResassuredStart()
		.when()
				.get("http://localhost:" + port + "/supermarket/1")
		.then()
				.statusCode(200)
				.body("id", equalTo(1))
				.body("name", equalTo("supername"));
	}

	private io.restassured.specification.RequestSpecification getAuthorizedResassuredStart(){
		return given()
				.auth().preemptive().basic("user", "password");
	}

}