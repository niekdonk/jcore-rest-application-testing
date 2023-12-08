package nl.jcore.demo.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class SupermarketJsonTest {

    @Autowired
    private JacksonTester<Supermarket> jsonTester;

    @Test
    public void testSerialize() throws IOException {
        Address address = new Address();
        address.setCity("Wageningen");
        address.setZipcode("6708 HZ");
        address.setStreet("Tarthorst");
        address.setHousenumber("1223");
        Supermarket supermarket = new Supermarket();
        supermarket.setId(5L);
        supermarket.setName("Jumbo");
        supermarket.setAddress(address);
        supermarket.setWozWaarde(331000.95);

        JsonContent<Supermarket> result = jsonTester.write(supermarket);

        assertThat(result).extractingJsonPathNumberValue("$.id").isEqualTo(5);
        assertThat(result).extractingJsonPathStringValue("$.name").isEqualTo("Jumbo");
        assertThat(result).extractingJsonPathStringValue("$.wozWaarde").isEqualTo("€331000.95");
    }
}
