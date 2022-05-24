package com.playground.jpa.example.nonidentifying2.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GrandChild4Id implements Serializable {

    private Child4Id child4Id; // @MapsId("child4Id")로 매핑

    @Column(name = "GRANDCHILD_ID")
    private String id;

    // equals, hashcode
}
