package com.manuelr.javaee.jaxrs.service;


import com.manuelr.javaee.jaxrs.entity.Department;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class QueryServiceTest {

    @InjectMocks
    QueryService queryService;

    @Mock
    EntityManager entityManager;

    @Before
    public void setUp() {
    }

    @Test
    public void getAllCourses() {
        List<Department> departments = queryService.getAllDepartments();
        departments.forEach((Assert::assertNotNull));
    }
}