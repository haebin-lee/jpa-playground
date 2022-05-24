package com.playground.jpa.example.nonidentifying2.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Child4Id implements Serializable {

    private String parentId; // @MapsId("parentId")로 매핑

    @Column(name = "CHILD_ID")
    private String id;

    // equals, hashcode..
}
