package com.manuelr.javaee.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Employee extends AbstractEntity {
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @Past(message = "Date of birth must be in the past")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private String birthDay;

    @NotNull(message = "Basic salary must be set")
    private BigDecimal basicSalary;

    @NotNull(message = "Hired date must be set")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    @PastOrPresent(message = "Hired date must be in the past or present")
    private LocalDate hiredDate;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    @Embedded
    private Address address;
}
