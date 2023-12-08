package nl.jcore.demo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "GROCERYSTOCK")
public class GroceryStockEntity {
	@EmbeddedId
	SuperMarketGroceryEmbeddable pk;
	Integer stock;
}
