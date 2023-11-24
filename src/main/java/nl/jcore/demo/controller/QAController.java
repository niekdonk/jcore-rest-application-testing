package nl.jcore.demo.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nl.jcore.demo.repository.SupermarketRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Profile("qa")
public class QAController {

    private final SupermarketRepository supermarketRepository;

    @DeleteMapping("/api/clearData")
    @Transactional
    public void clearData() {
        supermarketRepository.deleteAll();
    }
}
