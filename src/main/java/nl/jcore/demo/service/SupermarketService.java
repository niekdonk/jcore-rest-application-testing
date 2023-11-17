package nl.jcore.demo.service;

import nl.jcore.demo.model.Supermarket;
import nl.jcore.demo.repository.SupermarketRepository;
import org.springframework.stereotype.Service;

@Service
public class SupermarketService {

    SupermarketRepository supermarketRepository;

    public Supermarket getSupermarket(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
