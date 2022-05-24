package com.playground.jpa.example.nonidentifying2.entity;

import javax.persistence.*;

@Entity
public class GrandChild4 {

    @EmbeddedId
    private GrandChild4Id id;

    @MapsId("child4Id")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private Child4 child;

    private String name;

}
