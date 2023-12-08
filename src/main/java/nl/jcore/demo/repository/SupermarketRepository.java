package nl.jcore.demo.repository;

import nl.jcore.demo.entity.SupermarketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SupermarketRepository extends JpaRepository<SupermarketEntity, Long> {

}
