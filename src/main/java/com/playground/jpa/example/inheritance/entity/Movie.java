package com.playground.jpa.example.inheritance.entity;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Entity
@DiscriminatorValue("M")
public class Movie extends Item{

    private String director;    // 감독
    private String actor;       // 배우
}
