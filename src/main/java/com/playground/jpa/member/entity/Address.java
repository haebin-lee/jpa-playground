package com.playground.jpa.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@NoArgsConstructor
@Embeddable
public class Address {

    private String street;
    private String city;
    private String state;
//    @Embedded
//    private Zipcode zipcode;
    private String zipcode;
}
