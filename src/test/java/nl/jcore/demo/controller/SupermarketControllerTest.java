package nl.jcore.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("qa")
class SupermarketControllerTest {

    @Autowired
    private TestRestTemplate rest;

    @BeforeEach
    void beforeEach() {
        rest.delete("/api/clearData");
    }

    @Test
    void getSupermarket() {
        //TODO write test
    }

    @Test
    void postSupermarket() {
        //TODO write test
    }
}
