package com.manuelr.javaee.jaxrs.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "department")
@Getter
@Setter
@RequiredArgsConstructor
@NamedQuery(name = Department.FIND_ALL, query = "SELECT d from Department d")
@NamedQuery(name = Department.FIND_STUDENTS, query = "SELECT de from Department d JOIN d.students de " +
        "WHERE de.department.name = :departmentName")
public class Department {
    public static final String FIND_ALL = "Department.findAll";
    public static final String FIND_STUDENTS = "Department.findStudents";
    @Id
    @Column(name = "dept_name")
    private String name;
    @Column(name = "building")
    private String building;
    @Column(name = "budget", columnDefinition = "NUMERIC")
    private BigDecimal budget;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Student> students;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Student> instructors;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Course> courses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Department that = (Department) o;
        return name != null && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "building = " + building + ", " +
                "budget = " + budget + ")";
    }
}
