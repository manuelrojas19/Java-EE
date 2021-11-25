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
import java.util.Objects;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NamedQuery(name = Student.FIND_ALL, query = "SELECT s from Student s")
public class Student extends Person {
    public static final String FIND_ALL = "Student.findAll";

    @Column(name = "tot_cred", columnDefinition = "NUMERIC")
    private Integer credits;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return id != null && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
