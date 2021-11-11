package com.manuelr.javaee.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter @Setter
public class Tax extends AbstractEntity {
    private BigDecimal taxRate;
}
