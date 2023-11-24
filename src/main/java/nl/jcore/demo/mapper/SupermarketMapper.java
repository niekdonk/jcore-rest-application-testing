package nl.jcore.demo.mapper;

import nl.jcore.demo.entity.SupermarketEntity;
import nl.jcore.demo.model.Supermarket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface SupermarketMapper {
    SupermarketEntity toEntity(Supermarket supermarket);
    Supermarket toDto(SupermarketEntity supermarket);
}
