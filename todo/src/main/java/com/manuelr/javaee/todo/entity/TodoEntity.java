package com.manuelr.javaee.todo.entity;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@NotEmpty(message = "Task must be set")
	@Size(min = 10, message = "Task must no be less than 10 characters")
	private String task;
	@NotNull(message = "Due must be set")
	@FutureOrPresent(message = "Due must be in the present or future")
	@JsonbDateFormat(value = "yyyy-MM-dd")
	private LocalDate dueDate;
	private boolean isCompleted;
	private LocalDate dateCompleted;
	private LocalDate dateCreated;
	
	/*
	 * Life cycle callback
	 * Persist before the entity is persisted into the database
	 * */
	@PrePersist
	private void init() {
		setDateCreated(LocalDate.now());
	}
	
}
