package nl.jcore.demo.mapper;

import nl.jcore.demo.entity.GroceryEntity;
import nl.jcore.demo.model.Grocery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroceryMapper {
	GroceryEntity toEntity(Grocery address);
	Grocery toDto(GroceryEntity address);
}
