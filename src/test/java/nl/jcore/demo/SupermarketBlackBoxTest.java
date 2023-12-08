package nl.jcore.demo;

import com.jayway.jsonpath.JsonPath;
import nl.jcore.demo.mapper.SupermarketMapper;
import nl.jcore.demo.model.Address;
import nl.jcore.demo.model.Supermarket;
import nl.jcore.demo.repository.SupermarketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SupermarketBlackBoxTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private SupermarketRepository repository;

	@Autowired
	private SupermarketMapper mapper;

	@Test
	@Sql("/testdata.sql")
	void getSupermarket() throws Exception {
		//set data to get through api
		Supermarket model = new Supermarket();
		model.setName("super");
		final var address = new Address();
		address.setStreet("street");
		address.setCity("city");
		address.setZipcode("zipcode");
		address.setHousenumber("1337");
		model.setAddress(address);
		final var savedEntity =  repository.save(mapper.toEntity(model));

		//get data through api
		final var supermarket = getAuthenticatedRestTemplate()
				.getForObject("http://localhost:" + port + "/supermarket/1",
				String.class);

		assertEquals(model.getName(), JsonPath.parse(supermarket).read("$.name"));
		assertEquals(savedEntity.getId(), JsonPath.parse(supermarket).read("$.id", Long.class));

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