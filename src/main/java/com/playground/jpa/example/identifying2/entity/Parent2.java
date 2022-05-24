package com.playground.jpa.example.identifying2.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Parent2 {

    @EmbeddedId
    private Parent2Id id;

    private String name;
}
