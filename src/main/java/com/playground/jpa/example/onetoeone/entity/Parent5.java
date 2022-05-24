package com.playground.jpa.onetoeone.entity;

import com.playground.jpa.nonidentifying.entity.Child3;

import javax.persistence.*;

@Entity
public class Parent5 {

    @Id @GeneratedValue
    @Column(name = "PARNET_ID")
    private Long id;

    private String name;

    @OneToOne
    @JoinTable(name = "PARENT_CHILD",
            joinColumns = @JoinColumn(name = "PARENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
    )
    private Child5 child;
}
