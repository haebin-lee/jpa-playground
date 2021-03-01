package com.playground.jpa.nonidentifying.entity;

import java.io.Serializable;

public class GrandChild3Id implements Serializable {

    private Child3Id child;
    private String id;

    // equals, hashcode
}
