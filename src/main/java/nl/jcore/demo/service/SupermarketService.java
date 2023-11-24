package nl.jcore.demo.service;

import nl.jcore.demo.entity.SupermarketEntity;
import nl.jcore.demo.model.Supermarket;
import nl.jcore.demo.repository.SupermarketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupermarketService {
    private final ModelMapper modelMapper;
    private final SupermarketRepository supermarketRepository;

    @Autowired
    private SupermarketService(ModelMapper modelMapper, SupermarketRepository supermarketRepository) {
        this.modelMapper = modelMapper;
        this.supermarketRepository = supermarketRepository;
    }

    public Supermarket getSupermarket(Long id) {
        Optional<SupermarketEntity> supermarket = supermarketRepository.findById(id);
        return supermarket.map(s -> modelMapper.map(s, Supermarket.class)).orElseThrow();
    }

    public Supermarket persistSupermarket(Supermarket supermarket) {
        SupermarketEntity supermarketEntity = modelMapper.map(supermarket, SupermarketEntity.class);
        SupermarketEntity persistedSupermarketEntity = supermarketRepository.save(supermarketEntity);
        return modelMapper.map(persistedSupermarketEntity, Supermarket.class);
    }
}
