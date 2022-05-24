package com.playground.jpa.example.nonidentifying.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parent3 {

    @Id @Column(name = "PARENT_ID")
    private String id;
    private String name;
}
