package com.manuelr.javaee.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@NamedQuery(name = Employee.FIND_ALL, query = "SELECT e from Employee e")
@NamedQuery(name = Employee.FIND_BY_ID, query = "SELECT e FROM Employee e WHERE e.id = :id")
@NamedQuery(name = Employee.FIND_ALL_PARKING_SPACES, query = "SELECT e.parkingSpace FROM Employee e")
@NamedQuery(name = Employee.CONSTRUCTOR_PROJECTION, query = "SELECT new " +
        "com.manuelr.javaee.jpa.entity.EmployeeDetails(e.name, e.lastName, e.basicSalary) FROM Employee e")
@NamedQuery(name = Employee.FIND_EMPLOYEE_ALLOWANCES, query = "SELECT ea FROM Employee e JOIN e.allowances ea")
@Getter @Setter @NoArgsConstructor
public class Employee extends AbstractEntity {
    public static final String FIND_ALL = "Employee.findAll";
    public static final String FIND_BY_ID = "Employee.findById";
    public static final String FIND_ALL_PARKING_SPACES = "Employee.findAllParkingSpaces";
    public static final String CONSTRUCTOR_PROJECTION = "Employee.findDetails";
    public static final String FIND_EMPLOYEE_ALLOWANCES = "Employee.findAllowances";

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

    /*
     * Self relationship examples.
     * */
    @ManyToOne
    private Employee reportsTo;

    @OneToMany
    private Set<Employee> subordinates;

    /*
     * Enumeration example.
     * */
    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    /*
     * Embedded example
     * A embedded will not generate a new table, the fields of the embeddable
     * property will be merged in the table.
     * */
    @Embedded
    private Address address;

    /*
     * Example of many-to-one relationship
     * The attribute with the JoinColumn is the owner of the relationship
     * */
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    /*
     * Example of many-to-many relationship
     * */
    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;

    /*
     * Example of embeddable and collections relationship
     * */

    @ElementCollection
    @CollectionTable(name = "certifications", joinColumns = @JoinColumn(name = "emp_id"))
    private List<Certification> certifications;

    @ElementCollection
    @Column(name = "pronoun")
    private List<String> pronouns;


    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ParkingSpace parkingSpace;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Allowance> allowances;

    @ElementCollection
    @CollectionTable(name = "emp_phone_numbers")
    @MapKeyColumn(name = "phone_type")
    @Column(name = "phone_number")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<PhoneType, String> employeePhoneNumbers = new HashMap<>();

    @OneToMany(mappedBy = "employee")
    private List<Payslip> payslips;
}
