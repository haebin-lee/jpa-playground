package com.playground.jpa.example.oneton.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent6 {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    @OneToMany
    @JoinTable(name = "PARENT_CHILD",
            joinColumns = @JoinColumn(name = "PARENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
    )
    private List<Child6> child6 = new ArrayList<>();
}
