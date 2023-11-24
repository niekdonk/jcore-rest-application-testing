package nl.jcore.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SUPERMARKET")
public class SupermarketEntity {
    @Id
    private Long id;

    private String name;

    @Embedded
    private AddressEntity address;

}
