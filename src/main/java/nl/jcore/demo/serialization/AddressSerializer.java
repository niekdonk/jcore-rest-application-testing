package nl.jcore.demo.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import nl.jcore.demo.model.Address;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class AddressSerializer extends JsonSerializer<Address> {

    @Override
    public void serialize(Address address, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String addressString = String.format("%s %s, %s %s",
                address.getStreet(), address.getHousenumber(), address.getZipcode(), address.getCity());
        jsonGenerator.writeString(addressString);
    }

}
