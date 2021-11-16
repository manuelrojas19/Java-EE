package com.manuelr.javaee.jpa.service;

import com.manuelr.javaee.jpa.entity.Department;
import com.manuelr.javaee.jpa.entity.Employee;
import com.manuelr.javaee.jpa.entity.ParkingSpace;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class PersistenceService {

    @Inject
    EntityManager entityManager;

    @Inject
    QueryService queryService;

    /*
     *
     * */
    public Department saveDepartment(Department department) {
        entityManager.persist(department);
        return department;
    }

    public void removeParkingSpace(Long employeeId) {
        Employee employee = queryService.findEmployeeById(employeeId);
        ParkingSpace parkingSpace = employee.getParkingSpace();

        employee.setParkingSpace(null);

        entityManager.remove(parkingSpace);
    }

    public void saveEmployee(Employee employee, ParkingSpace parkingSpace) {
        employee.setParkingSpace(parkingSpace);
        entityManager.persist(employee);
    }

    public void updateDepartment(Department department) {
        entityManager.merge(department);
    }
}
