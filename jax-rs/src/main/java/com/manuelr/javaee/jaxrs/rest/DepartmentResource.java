package com.manuelr.javaee.jaxrs.rest;

import com.manuelr.javaee.jaxrs.entity.Department;
import com.manuelr.javaee.jaxrs.entity.Student;
import com.manuelr.javaee.jaxrs.service.QueryService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("departments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    @Inject
    QueryService queryService;

    @GET
    public Response getAllDepartments() {
        List<Department> departments = queryService.getAllDepartments();
        return Response.ok(departments).build();
    }

    @GET
    @Path("{departmentName}/students")
    public Response getStudentsByDepartment(@PathParam("departmentName") String departmentName) {
        List<Student> students = queryService.getStudentsByDepartment(departmentName);
        return Response.ok(students).build();
    }
}
