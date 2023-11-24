package nl.jcore.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressEntity {
    private String street;
    private String housenumber;
    private String zipcode;
    private String city;
}
