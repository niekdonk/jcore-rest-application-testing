package nl.jcore.demo.repository;

import nl.jcore.demo.entity.GroceryStockEntity;
import nl.jcore.demo.entity.SuperMarketGroceryEmbeddable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GroceryStockRepository extends CrudRepository<GroceryStockEntity, SuperMarketGroceryEmbeddable> {

	@Query("SELECT p FROM GroceryStockEntity p WHERE p.pk.supermarketId = :supermarket AND p.pk.groceryId = :grocery")
	Optional<GroceryStockEntity> findByCompositeKeys(@Param("supermarket") Long supermarket, @Param("grocery") Long grocery);

	@Query("DELETE FROM GroceryStockEntity p WHERE p.pk.supermarketId = :supermarket AND p.pk.groceryId = :grocery")
	void deleteByCompositeKey(@Param("supermarket") Long supermarket, @Param("grocery") Long grocery);
}
