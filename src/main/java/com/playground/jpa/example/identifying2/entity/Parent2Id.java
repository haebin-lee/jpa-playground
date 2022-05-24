package com.playground.jpa.example.identifying2.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Parent2Id implements Serializable {

    @Column(name = "PARENT_ID1")
    private String id1;
    @Column(name = "PARENT_ID2")
    private String id2;

    public Parent2Id(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }
    // equals and hascode 구현
}
