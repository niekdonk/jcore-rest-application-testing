package nl.jcore.demo;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

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

}


//spring-boot-starter-json

//hoe doe je een black box test
//waarom doe je een blackbox test
//wat is de kracht van een black box test


//niet nodig in blackbox om de inhoud te testen als je bijvoorbeeld jsontests hebt die al testen of het goed geserializeerd word.
//en unit test die afvangen dat je allen maar valide objecten kan maken.