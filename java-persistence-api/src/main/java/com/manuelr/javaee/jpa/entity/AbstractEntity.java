package com.manuelr.javaee.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@AttributeOverride(name = "id", column = @Column(name = "tax_id"))
@Getter @Setter
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String email;

    @Version
    protected Long version;

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

}
