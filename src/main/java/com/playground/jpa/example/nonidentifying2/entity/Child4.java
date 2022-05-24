package com.playground.jpa.example.nonidentifying2.entity;

import javax.persistence.*;

@Entity
public class Child4 {

    @EmbeddedId
    private Child4Id id;

    @MapsId("parentId") // ChildId.parentId
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent4 parent;

    private String name;

}
