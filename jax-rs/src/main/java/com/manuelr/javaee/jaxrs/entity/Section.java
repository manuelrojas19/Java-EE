package com.manuelr.javaee.jaxrs.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "section")
@Getter
@Setter
@RequiredArgsConstructor
public class Section {

    @Id
    @Column(name = "sec_id")
    private String id;

    @MapsId("id")
    @JoinColumns({
            @JoinColumn(name = "building", referencedColumnName = "building"),
            @JoinColumn(name = "room_number", referencedColumnName = "room_number")
    })
    @ManyToOne
    private Classroom classroom;
}
