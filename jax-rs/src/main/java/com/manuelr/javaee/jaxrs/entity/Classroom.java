package com.manuelr.javaee.jaxrs.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "classroom")
@Getter
@Setter
@RequiredArgsConstructor
@NamedQuery(name = Classroom.FIND_ALL, query = "SELECT c from Classroom c")
public class Classroom {
    public static final String FIND_ALL = "Classroom.findAll";
    @EmbeddedId
    private ClassroomId id;

    @Column(name = "capacity", columnDefinition = "NUMERIC")
    private Integer capacity;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class ClassroomId implements Serializable {
        @Column(name = "building")
        protected String building;

        @Column(name = "room_number")
        protected String roomNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Classroom classroom = (Classroom) o;
        return id != null && Objects.equals(id, classroom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
