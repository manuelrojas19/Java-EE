package com.manuelr.javaee.jaxrs.rest;

import com.manuelr.javaee.jaxrs.entity.Classroom;
import com.manuelr.javaee.jaxrs.entity.Course;
import com.manuelr.javaee.jaxrs.service.QueryService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("classrooms")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClassroomResource {

    @Inject
    QueryService queryService;

    @GET
    public Response getAllClassrooms() {
        List<Classroom> classrooms = queryService.getAllClassrooms();
        return Response.ok(classrooms).build();
    }
}
