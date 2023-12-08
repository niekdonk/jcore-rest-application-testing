package nl.jcore.demo.controller;

import lombok.RequiredArgsConstructor;
import nl.jcore.demo.model.GroceryStock;
import nl.jcore.demo.service.GroceryStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class GroceryStockController {
	private final GroceryStockService stockService;
	private static final String baseURIString = "/stock";
	private static final URI baseURI = URI.create(baseURIString + "/");

	@GetMapping(baseURIString + "/{superMarketId}/{groceryId}")
	public GroceryStock getGrocery(@PathVariable Long superMarketId, @PathVariable Long groceryId) {
		return stockService.getGroceryStock(superMarketId, groceryId).orElseThrow();
	}

	@PostMapping(baseURIString)
	public ResponseEntity postGrocery(@RequestBody GroceryStock groceryStock) {
		var persistedGroceryStock = stockService.persistGrocery(groceryStock);
		var supermarketId = persistedGroceryStock.supermarketGrocery().supermarket().getId();
		var groceryId = persistedGroceryStock.supermarketGrocery().grocery().id();
		final var location = baseURI.resolve(supermarketId + "/" + groceryId);
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(baseURIString)
	public ResponseEntity deleteGrocery(@RequestParam Long supermarketId, @RequestParam Long groceryId) {
		stockService.deleteGrocery(supermarketId, groceryId);
		return ResponseEntity.ok().build();
	}
}
