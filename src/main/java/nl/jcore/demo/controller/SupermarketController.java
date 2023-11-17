package nl.jcore.demo.controller;

import nl.jcore.demo.model.Supermarket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupermarketController {



    @GetMapping("/supermarket/{id}")
    public Supermarket getSupermarket() {
        //todo get supermarket from database
        return null;
    }

    @PostMapping("/supermarket")
    public Supermarket postSupermarket(@RequestBody Supermarket supermarket) {
        //TODO save supermarket to database
        return supermarket;
    }

    @DeleteMapping("/supermarket")
    public ResponseEntity deleteSupermarket(@RequestParam Long id) {
        //TODO delete supermarket from database
        return ResponseEntity.ok().build();
    }

}
