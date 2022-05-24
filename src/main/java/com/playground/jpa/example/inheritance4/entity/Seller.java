package com.playground.jpa.example.inheritance4.entity;

import javax.persistence.Entity;

@Entity
public class Seller extends BaseEntity{

    // ID 상속
    // NAME 상속
    private String shopName;
}
