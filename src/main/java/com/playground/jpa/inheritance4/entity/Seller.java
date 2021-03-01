package com.playground.jpa.inheritance4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Seller extends BaseEntity{

    // ID 상속
    // NAME 상속
    private String shopName;
}
