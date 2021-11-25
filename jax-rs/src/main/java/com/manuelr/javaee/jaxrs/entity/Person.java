package com.manuelr.javaee.jaxrs.entity;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class Person {
    @Id
    protected String id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "dept_name")
    @JsonbTransient
    protected Department department;
}
