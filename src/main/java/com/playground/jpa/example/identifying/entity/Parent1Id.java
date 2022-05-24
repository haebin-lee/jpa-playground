package com.playground.jpa.example.identifying.entity;

import java.io.Serializable;

public class Parent1Id implements Serializable {

    private String id1;
    private String id2;

    public Parent1Id() {

    }

    public Parent1Id(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    // hashcode, equals 정의
}
