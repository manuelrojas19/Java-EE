package com.manuelr.javaee.jaxrs.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
@RequiredArgsConstructor
@NamedQuery(name = Course.FIND_ALL, query = "SELECT c FROM Course c")
@NamedQuery(name = Course.FIND_PRE_REQ, query = "SELECT c.prerequisite from Course c where c.id = :courseId")
public class Course {
    public static final String FIND_ALL = "Course.findAll";
    public static final String FIND_PRE_REQ = "Course.findPreReq";

    @Id
    @Column(name = "course_id")
    private String id;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "dept_name")
    @JsonbTransient
    private Department department;
    @Column(name = "credits", columnDefinition = "NUMERIC")
    private BigDecimal credits;
    @ManyToMany
    @JoinTable(name = "prereq",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "prereq_id"))
    @JsonbTransient
    private Set<Course> prerequisite;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return id != null && Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
