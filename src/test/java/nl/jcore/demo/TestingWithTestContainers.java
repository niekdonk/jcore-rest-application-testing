package nl.jcore.demo;

import net.datafaker.Faker;
import nl.jcore.demo.entity.AddressEntity;
import nl.jcore.demo.entity.SupermarketEntity;
import nl.jcore.demo.repository.SupermarketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Disable the testdatabase so we sure the mysql testcontainer will be used
@DataJpaTest
@Testcontainers
class TestingWithTestContainers {

    @Autowired
    private SupermarketRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Container
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>(MySQLContainer.NAME).withReuse(true).withDatabaseName("test");

    @Test
    void shouldStartupMysql() {
        assertThat(mySQLContainer.isRunning());
        var supermarkt = maakEntity();

        repository.save(supermarkt);
        repository.flush();

        List<SupermarketEntity> supermarkets = jdbcTemplate.query(
                "SELECT * FROM SUPERMARKET",
                (rs, rowNum) -> {
                    SupermarketEntity supermarket = new SupermarketEntity();
                    supermarket.setId(rs.getLong("id"));
                    supermarket.setName(rs.getString("name"));

                    return supermarket;
                });

        for(SupermarketEntity supermarketEntity : supermarkets){
            assertEquals(1, supermarketEntity.getId());
            assertEquals("jumbo", supermarketEntity.getName());
        }
    }

    private SupermarketEntity maakEntity(){
        var adres = new AddressEntity();
        adres.setStreet("Coltbaan");
        adres.setHousenumber("4");
        adres.setZipcode("2371 EA");
        adres.setCity("Utrecht");

        var supermarkt = new SupermarketEntity();
        supermarkt.setAddress(adres);
        supermarkt.setName("jumbo");

        return supermarkt;
    }

}

// blackbox of whitebox test
// integratietest
// springboottest
// alleen de componenten of externe componenten
// hoe efficient testcontainer opzetten
// beter om mysql container te gebruiken dan een in memory h2