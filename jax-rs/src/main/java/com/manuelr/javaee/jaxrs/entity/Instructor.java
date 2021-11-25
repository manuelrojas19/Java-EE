package com.manuelr.javaee.jaxrs.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "instructor")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NamedQuery(name = Instructor.FIND_ALL, query = "SELECT i from Instructor i")
public class Instructor extends Person {
    public static final String FIND_ALL = "Instructor.findAll";

    @Column(name = "salary", columnDefinition = "NUMERIC")
    private BigDecimal salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Instructor that = (Instructor) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
