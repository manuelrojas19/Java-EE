package com.manuelr.javaee.todo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.manuelr.javaee.todo.entity.TodoEntity;

@Transactional
public class TodoService {
	@PersistenceContext
	EntityManager entityManager;
	
	public TodoEntity createTodo(TodoEntity todo) {
		entityManager.persist(todo);
		return todo;
	}

	public TodoEntity updateTodo(TodoEntity todo) {
		entityManager.merge(todo);
		return todo;
	}
	
	public TodoEntity findTodoById(Long id) {
		return entityManager.find(TodoEntity.class, id);
	}
	
	public List<TodoEntity> getTodos() {
		return entityManager.createQuery("SELECT t from Todo t", 
				TodoEntity.class).getResultList();
	}
}
