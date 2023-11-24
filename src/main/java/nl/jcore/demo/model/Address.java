package nl.jcore.demo.model;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String housenumber;
    private String zipcode;
    private String city;
}
