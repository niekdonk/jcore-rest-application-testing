package nl.jcore.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SUPERMARKET")
public class SupermarketEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private AddressEntity address;

    private Double wozWaarde;

}
