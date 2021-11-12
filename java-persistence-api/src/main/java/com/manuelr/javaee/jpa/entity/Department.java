package com.manuelr.javaee.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

@Entity
@Getter @Setter
public class Department extends AbstractEntity {
    @NotEmpty(message = "Name must be set")
    private String name;

    @Transient
    private String departmentCode;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

//    @OneToMany
//    @MapKey(name = "id")
//    @JoinTable(name = "dept_employees")
//    private Map<Long, Employee> employees;

    @ElementCollection
    @CollectionTable(name = "dept_ranks")
    @MapKeyJoinColumn(name = "emp_id")
    @Column(name = "rank")
    private Map<Employee, Integer> departmentRanks;

}
