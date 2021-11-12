package com.manuelr.javaee.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "tax_id"))
@Getter @Setter
public class Tax extends AbstractEntity {
    private BigDecimal taxRate;
}
