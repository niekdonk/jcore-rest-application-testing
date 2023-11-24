package nl.jcore.demo.controller;

import nl.jcore.demo.model.Supermarket;
import nl.jcore.demo.service.SupermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupermarketController {
    private SupermarketService supermarketService;

    @Autowired
    public SupermarketController(SupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }

    @GetMapping("/supermarket/{id}")
    public Supermarket getSupermarket(@PathVariable Long id) {
        return supermarketService.getSupermarket(id);
    }

    @PostMapping("/supermarket")
    public Supermarket postSupermarket(@RequestBody Supermarket supermarket) {
        return supermarketService.persistSupermarket(supermarket);
    }

    @DeleteMapping("/supermarket")
    public ResponseEntity deleteSupermarket(@RequestParam Long id) {
        //TODO delete supermarket from database
        return ResponseEntity.ok().build();
    }

}
