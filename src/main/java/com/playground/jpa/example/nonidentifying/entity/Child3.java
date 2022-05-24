package com.playground.jpa.nonidentifying.entity;

import javax.persistence.*;

@Entity
@IdClass(Child3Id.class)
public class Child3 {

    @Id
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent3 parent;

    @Id @Column(name = "CHILD_ID")
    private String childId;

    private String name;

}
