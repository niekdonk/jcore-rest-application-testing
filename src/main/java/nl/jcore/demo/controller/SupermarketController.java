package nl.jcore.demo.controller;

import nl.jcore.demo.model.Supermarket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupermarketController {

    @GetMapping("/supermarket")
    public Supermarket getSupermarket() {
        //todo get supermarket from database

        Supermarket supermarket = new Supermarket();
        supermarket.setName("Albert Heijn");
        supermarket.setAddress("Kerkstraat 1");
        supermarket.setCity("Amsterdam");
        return supermarket;
    }

    @PostMapping("/supermarket")
    public Supermarket postSupermarket(@RequestBody Supermarket supermarket) {
        //TODO save supermarket to database
        return supermarket;
    }

}
