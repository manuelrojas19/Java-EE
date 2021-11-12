package com.manuelr.javaee.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter @Setter
public class Payslip extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private BigDecimal basicSalary;
    private BigDecimal allowances;
    private BigDecimal deductions;
}
