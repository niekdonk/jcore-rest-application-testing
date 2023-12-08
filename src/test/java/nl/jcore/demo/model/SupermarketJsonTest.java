package nl.jcore.demo.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@JsonTest
public class SupermarketJsonTest {

    @Autowired
    private JacksonTester<Supermarket> jsonTester;

    @Test
    void testSerialize() throws IOException {
        Supermarket supermarket = new Supermarket();
        supermarket.setId(5L);
        supermarket.setName("Jumbo");
        supermarket.setAddress("Tarthorst 1223, 6708 HZ Wageningen");
        supermarket.setWozWaarde(331000.95);

        JsonContent<Supermarket> result = jsonTester.write(supermarket);

        assertThat(result).extractingJsonPathNumberValue("$.id").isEqualTo(5);
        assertThat(result).extractingJsonPathStringValue("$.name").isEqualTo("Jumbo");
        assertThat(result).extractingJsonPathStringValue("$.address").isEqualTo("Tarthorst 1223, 6708 HZ Wageningen");
        assertThat(result).extractingJsonPathStringValue("$.wozWaarde").isEqualTo("€331000.95");
    }

    @Test
    void testDeserialize() throws IOException {
        String supermarketJson = "{\"id\":5,\"name\":\"Jumbo\",\"address\":\"Tarthorst 1223, 6708 HZ Wageningen\",\"wozWaarde\":\"€331000.95\"}";
        Supermarket expectedSupermarket = new Supermarket();
        expectedSupermarket.setId(5L);
        expectedSupermarket.setName("Jumbo");
        expectedSupermarket.setAddress("Tarthorst 1223, 6708 HZ Wageningen");
        expectedSupermarket.setWozWaarde(331000.95);

        Supermarket actualSupermarket = jsonTester.parseObject(supermarketJson);
        assertEquals(expectedSupermarket.getId(), actualSupermarket.getId());
        assertEquals(expectedSupermarket.getName(), actualSupermarket.getName());
        assertEquals(expectedSupermarket.getAddress(), actualSupermarket.getAddress());
        assertEquals(expectedSupermarket.getWozWaarde(), actualSupermarket.getWozWaarde());
    }
}
