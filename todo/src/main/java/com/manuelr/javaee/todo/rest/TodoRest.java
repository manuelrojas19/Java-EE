package com.manuelr.javaee.todo.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.manuelr.javaee.todo.entity.TodoEntity;
import com.manuelr.javaee.todo.service.TodoService;


@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {

	@Inject
	TodoService todoService;

	@Path("new")
	@POST
	public Response createTodo(TodoEntity todo) {
		TodoEntity response = todoService.createTodo(todo);
		return Response.ok(response).build();
	}
	
	@Path("update")
	@PUT
	public Response updateTodo(TodoEntity todo) {
		TodoEntity response = todoService.updateTodo(todo);
		return Response.ok(response).build();
	}

	@Path("{id}")
	@GET
	public Response getTodo(@PathParam("id") Long id) {
		TodoEntity response = todoService.findTodoById(id);
		return Response.ok(response).build();
	}
	
	@Path("list")
	@GET
	public Response getAllTodos() {
		List<TodoEntity> response = todoService.getTodos();
		return Response.ok(response).build();
	}
	
	@Path("mark-as-complete")
	@POST
	public Response markAsComplete(@QueryParam("id") Long id) {
		TodoEntity todo = todoService.findTodoById(id);
		todo.setCompleted(true);
		TodoEntity response = todoService.updateTodo(todo);
		return Response.ok(response).build();
	}
}
