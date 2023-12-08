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

    private String address;

    private Double wozWaarde;

}
