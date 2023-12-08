package nl.jcore.demo.service;

import lombok.RequiredArgsConstructor;
import nl.jcore.demo.entity.GroceryEntity;
import nl.jcore.demo.mapper.GroceryMapper;
import nl.jcore.demo.model.Grocery;
import nl.jcore.demo.repository.GroceryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroceryService {
	private final GroceryRepository groceryRepository;
	private final GroceryMapper mapper;

	public Optional<Grocery> getGrocery(Long id) {
		return groceryRepository.findById(id)
				.map(mapper::toDto);
	}

	public void deleteGrocery(Long id) {
		groceryRepository.deleteById(id);
	}

	public Grocery persistGrocery(Grocery grocery) {
		GroceryEntity groceryEntity = mapper.toEntity(grocery);
		GroceryEntity persistedGroceryEntity = groceryRepository.save(groceryEntity);
		return mapper.toDto(persistedGroceryEntity);
	}
}
