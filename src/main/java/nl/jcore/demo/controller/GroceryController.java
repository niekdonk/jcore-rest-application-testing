package nl.jcore.demo.controller;

import lombok.RequiredArgsConstructor;
import nl.jcore.demo.model.Grocery;
import nl.jcore.demo.model.Grocery;
import nl.jcore.demo.model.Supermarket;
import nl.jcore.demo.service.GroceryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GroceryController {
	private final GroceryService service;
	private static final String baseURIString = "/grocery";
	private static final URI baseURI = URI.create(baseURIString + "/");
	@GetMapping( baseURIString + "/{id}")
	public Grocery getGrocery(@PathVariable Long id) {
		return service.getGrocery(id).orElseThrow();
	}

	@PostMapping(baseURIString)
	public ResponseEntity postGrocery(@RequestBody Grocery grocery) {
		var persistedGrocery = service.persistGrocery(grocery);
		final var location = baseURI.resolve(persistedGrocery.id().toString());
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(baseURIString)
	public ResponseEntity deleteGrocery(@RequestParam Long id) {
		service.deleteGrocery(id);
		return ResponseEntity.ok().build();
	}
}
