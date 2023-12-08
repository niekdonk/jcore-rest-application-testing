package nl.jcore.demo.model;

import lombok.Data;

@Data
public class Supermarket {

    private Long id;
    private String name;
    private Address address;
    private Double wozWaarde;

}
