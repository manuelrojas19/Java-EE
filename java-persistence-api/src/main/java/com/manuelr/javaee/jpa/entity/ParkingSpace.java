package com.manuelr.javaee.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter @Setter
public class ParkingSpace extends AbstractEntity {
    private String lotNumber;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
