package nl.jcore.demo.mapper;

import nl.jcore.demo.entity.GroceryStockEntity;
import nl.jcore.demo.model.GroceryStock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SupermarketGroceryMapper.class)
public interface GroceryStockMapper {
	GroceryStockEntity toEntity(GroceryStock address);
	GroceryStock toDto(GroceryStockEntity address);
}
