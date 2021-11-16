package com.manuelr.javaee.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

@Entity
@NamedQuery(name = Department.FIND_ALL, query = "SELECT d FROM Department d")
@NamedQuery(name = Department.FIND_BY_ID, query = "SELECT d FROM Department d WHERE d.name = :name")
@NamedQuery(name = Department.FIND_NAMES, query = "SELECT d.name FROM Department d")
@Getter @Setter @NoArgsConstructor
public class Department extends AbstractEntity {
    public static final String FIND_ALL = "Department.findAll";
    public static final String FIND_BY_ID = "Department.findById";
    public static final String FIND_BY_NAME = "Department.findByName";
    public static final String FIND_NAMES = "Department.findNames";

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
