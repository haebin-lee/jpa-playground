package com.playground.jpa.nonidentifying2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parent4 {

    @Id @Column(name = "PARENT_ID")
    private String id;
    private String name;
}
