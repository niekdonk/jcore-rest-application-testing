package nl.jcore.demo.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.TextNode;
import nl.jcore.demo.model.Supermarket;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class SupermarketDeserializer  extends JsonDeserializer<Supermarket> {

    @Override
    public Supermarket deserialize(JsonParser jsonParser,
                                   DeserializationContext deserializationContext) throws IOException {

        Supermarket supermarket = new Supermarket();
        TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        IntNode id = (IntNode) treeNode.get("id");
        TextNode name = (TextNode) treeNode.get("name");
        TextNode address = (TextNode) treeNode.get("address");
        TextNode wozWaarde = (TextNode) treeNode.get("wozWaarde");
        supermarket.setId(id.longValue());
        supermarket.setName(name.textValue());
        supermarket.setAddress(address.textValue());
        supermarket.setWozWaarde(Double.valueOf(wozWaarde.textValue().replace("€", "")));
        return supermarket;
    }
}
