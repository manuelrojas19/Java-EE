package com.manuelr.javaee.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter @Setter
public class Certification {
    private String name;
    private String company;
    private LocalDate obtainedAt;
}
