package com.manuelr.javaee.jaxrs.service;

import com.manuelr.javaee.jaxrs.entity.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class QueryService {

    @Inject
    EntityManager entityManager;

    public List<Classroom> getAllClassrooms() {
        return entityManager.createNamedQuery(Classroom.FIND_ALL, Classroom.class).getResultList();
    }


    public List<Department> getAllDepartments() {
        return entityManager.createNamedQuery(Department.FIND_ALL, Department.class).getResultList();
    }

    public List<Course> getAllCourses() {
        return entityManager.createNamedQuery(Course.FIND_ALL, Course.class).getResultList();
    }

    public List<Student> getAllStudents() {
        return entityManager.createNamedQuery(Student.FIND_ALL, Student.class).getResultList();
    }

    public List<Student> getStudentsByDepartment(String departmentName) {
        return entityManager.createNamedQuery(Department.FIND_STUDENTS, Student.class)
                .setParameter("departmentName", departmentName).getResultList();
    }

    public List<Instructor> getAllInstructors() {
        return entityManager.createNamedQuery(Instructor.FIND_ALL, Instructor.class).getResultList();
    }
}
