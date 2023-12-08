package nl.jcore.demo.service;

import nl.jcore.demo.model.Supermarket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ImportTestcontainers
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class SupermarketServiceTest {

    @Container
    @ServiceConnection
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>(MySQLContainer.NAME).withReuse(true).withUsername("root").withPassword("root");

    @Autowired
    private SupermarketService supermarketService;

    @Test
    void getSupermarketShouldGetSupermarket() {
        Supermarket supermarket = new Supermarket();
        supermarket.setName("Test Supermarket");
        supermarket.setAddress("Test Address");

        var savedSupermarket = supermarketService.persistSupermarket(supermarket);
        Supermarket result = supermarketService.getSupermarket(savedSupermarket.getId());

        assertEquals(supermarket.getName(), result.getName());
        assertEquals(supermarket.getAddress(), result.getAddress());
    }

    @Test
    void getSupermarketShouldThrowWhenNotExists() {
        assertThrows(NoSuchElementException.class, () -> supermarketService.getSupermarket(1L));
    }

    @Test
    void persistSupermarket() {
        Supermarket supermarket = new Supermarket();
        supermarket.setName("Test Supermarket");
        supermarket.setAddress("Test Address");

        Supermarket result = supermarketService.persistSupermarket(supermarket);

        assertEquals(supermarket.getName(), result.getName());
        assertEquals(supermarket.getAddress(), result.getAddress());
    }

    @Test
    void persistSupermarketShouldEnsureNameIsUnique() {
        Supermarket supermarket1 = new Supermarket();
        supermarket1.setName("Test Supermarket");
        supermarket1.setAddress("Test Address1");

        Supermarket supermarket2 = new Supermarket();
        supermarket2.setName("Test Supermarket");
        supermarket1.setAddress("Test Address2");

        supermarketService.persistSupermarket(supermarket1);

        assertThrows(DataIntegrityViolationException.class, () -> supermarketService.persistSupermarket(supermarket2));
    }
}
