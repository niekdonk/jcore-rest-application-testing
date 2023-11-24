package nl.jcore.demo.mapper;

import nl.jcore.demo.entity.AddressEntity;
import nl.jcore.demo.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressEntity toEntity(Address address);
    Address toDto(AddressEntity address);
}
