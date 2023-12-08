package nl.jcore.demo.mapper;

import nl.jcore.demo.entity.SuperMarketGroceryEmbeddable;
import nl.jcore.demo.model.SupermarketGrocery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupermarketGroceryMapper {
	SuperMarketGroceryEmbeddable toEntity(SupermarketGrocery address);
	SupermarketGrocery toDto(SuperMarketGroceryEmbeddable address);
}
