package nl.jcore.demo.service;

import nl.jcore.demo.entity.SupermarketEntity;
import nl.jcore.demo.mapper.SupermarketMapper;
import nl.jcore.demo.model.Supermarket;
import nl.jcore.demo.repository.SupermarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupermarketService {
    private final SupermarketMapper supermarketMapper;
    private final SupermarketRepository supermarketRepository;

    @Autowired
    private SupermarketService(SupermarketMapper supermarketMapper, SupermarketRepository supermarketRepository) {
        this.supermarketMapper = supermarketMapper;
        this.supermarketRepository = supermarketRepository;
    }

    public Supermarket getSupermarket(Long id) {
        Optional<SupermarketEntity> supermarket = supermarketRepository.findById(id);
        return supermarket.map(supermarketMapper::toDto).orElseThrow();
    }

    public Supermarket persistSupermarket(Supermarket supermarket) {
        SupermarketEntity supermarketEntity = supermarketMapper.toEntity(supermarket);
        SupermarketEntity persistedSupermarketEntity = supermarketRepository.save(supermarketEntity);
        return supermarketMapper.toDto(persistedSupermarketEntity);
    }
}
