package nl.jcore.demo.service;

import lombok.RequiredArgsConstructor;
import nl.jcore.demo.entity.SuperMarketGroceryEmbeddable;
import nl.jcore.demo.mapper.GroceryStockMapper;
import nl.jcore.demo.mapper.SupermarketGroceryMapper;
import nl.jcore.demo.model.GroceryStock;
import nl.jcore.demo.model.SupermarketGrocery;
import nl.jcore.demo.repository.GroceryRepository;
import nl.jcore.demo.repository.GroceryStockRepository;
import nl.jcore.demo.repository.SupermarketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroceryStockService {
	private final GroceryStockMapper stockMapper;
	private final GroceryStockRepository stockRepository;
	public Optional<GroceryStock> getGroceryStock(Long supermarketId, Long groceryId) {
		final var stockEntiy = stockRepository.findByCompositeKeys(supermarketId, groceryId);
		return stockEntiy.map(stockMapper::toDto);
	}

	public GroceryStock persistGrocery(GroceryStock groceryStock) {
		final var stockEntity = stockMapper.toEntity(groceryStock);
		var savedStock = stockRepository.save(stockEntity);
		return stockMapper.toDto(savedStock);
	}

	public void deleteGrocery(Long supermarketId, Long groceryId) {
		stockRepository.deleteByCompositeKey(supermarketId, groceryId);
	}
}
