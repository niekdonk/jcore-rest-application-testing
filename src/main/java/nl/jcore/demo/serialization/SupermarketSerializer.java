package nl.jcore.demo.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import nl.jcore.demo.model.Supermarket;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class SupermarketSerializer extends JsonSerializer<Supermarket> {

    @Override
    public void serialize(Supermarket supermarket, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", supermarket.getId());
        jsonGenerator.writeStringField("name", supermarket.getName());
        jsonGenerator.writeObjectField("address", supermarket.getAddress());
        jsonGenerator.writeStringField(
                "wozWaarde",
                "€" + supermarket.getWozWaarde());
        jsonGenerator.writeEndObject();
    }

}
