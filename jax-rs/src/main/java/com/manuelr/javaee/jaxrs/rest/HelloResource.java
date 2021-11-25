package com.manuelr.javaee.jaxrs.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloResource {

    @Path("{name}")
    @GET
    public Response sayHello(@PathParam("name") String name) {
        return Response.ok("Hello " + name).build();
    }

    @Path("greet")
    @GET
    public String greet() {
        return "Hello world";
    }
}
