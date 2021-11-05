package com.manuelr.javaee.todo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TodoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String task;
	private LocalDate dueDate;
	private boolean isCompleted;
	private LocalDate dateCompleted;
	private LocalDate dateCreated;
	
	/*
	 * Lifecycle callback
	 * Persist before the entity is persisted into the database
	 * */
	@PrePersist
	private void init() {
		setDateCreated(LocalDate.now());
	}
	
}
