package nl.jcore.demo.repository;

import nl.jcore.demo.entity.GroceryEntity;
import nl.jcore.demo.entity.SupermarketEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GroceryRepository  extends CrudRepository<GroceryEntity, Long> {

}