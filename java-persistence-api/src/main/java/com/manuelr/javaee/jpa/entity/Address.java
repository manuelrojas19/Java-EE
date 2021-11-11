package com.manuelr.javaee.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class Address {
    private String streetAddress;
    private String zipCode;
    private String city;
    private String country;
    private String phone;
}