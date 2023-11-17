package nl.jcore.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SupermarketEntity {
    @Id
    private Long id;

    private String name;

    private String address;

    private String city;
}
