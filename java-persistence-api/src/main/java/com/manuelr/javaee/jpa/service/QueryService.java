package com.manuelr.javaee.jpa.service;

import com.manuelr.javaee.jpa.entity.Department;
import com.manuelr.javaee.jpa.entity.Employee;
import com.manuelr.javaee.jpa.entity.EmployeeDetails;
import com.manuelr.javaee.jpa.entity.ParkingSpace;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/*
 * By default, the container manage the transactions
 * */

//@TransactionManagement(TransactionManagementType.BEAN) With this the bean manage the transaction
@Singleton
@Startup
public class QueryService {

    @Inject
    EntityManager entityManager;

    @PostConstruct
    private void init() {

    }

    @PreDestroy
    private void destroy() {

    }

    public Employee findEmployeeById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    public List<String> getDepartmentNames() {
        return entityManager.createNamedQuery(Department.FIND_NAMES, String.class).getResultList();
    }

    public List<EmployeeDetails> findAllEmployeeDetails() {
        return entityManager.createNamedQuery(Employee.CONSTRUCTOR_PROJECTION, EmployeeDetails.class).getResultList();
    }

    public List<Department> findALlDepartments() {
        return entityManager.createNamedQuery(Department.FIND_ALL, Department.class)
                .getResultList();
    }

    public List<ParkingSpace> findAllocatedParkingSpaces() {
        return entityManager.createNamedQuery(Employee.FIND_ALL_PARKING_SPACES, ParkingSpace.class)
                .getResultList();
    }

//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
//    public List<Employee> getEmployees() {
//        return null;
//    }
}
