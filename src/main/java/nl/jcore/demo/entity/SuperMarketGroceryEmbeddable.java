package nl.jcore.demo.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperMarketGroceryEmbeddable implements Serializable {
	@ManyToOne
	@JoinColumn(name = "SUPERMARKET_id")
	SupermarketEntity supermarketId;
	@ManyToOne
	@JoinColumn(name = "GROCERY_id")
	GroceryEntity groceryId;
}
