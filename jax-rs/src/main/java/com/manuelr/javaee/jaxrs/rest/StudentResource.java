package com.manuelr.javaee.jaxrs.rest;

import com.manuelr.javaee.jaxrs.entity.Student;
import com.manuelr.javaee.jaxrs.service.QueryService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {
    @Inject
    QueryService queryService;

    @GET
    public Response getAllStudents() {
        List<Student> students = queryService.getAllStudents();
        Map<String, List> response = Collections.singletonMap("data", students);
        return Response.ok(response).build();
    }
}
