package com.playground.jpa.nonidentifying.entity;

import javax.persistence.*;

@Entity
@IdClass(GrandChild3Id.class)
public class GrandChild3 {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private Child3 child;

    @Id @Column(name = "GRANDCHILD_ID")
    private String id;

    private String name;

}
