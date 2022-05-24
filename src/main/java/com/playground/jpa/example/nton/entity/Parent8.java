package com.playground.jpa.example.nton.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent8 {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "PARENT_CHILD",
            joinColumns = @JoinColumn(name = "PARENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
    )
    private List<Child8> child = new ArrayList<>();
}
