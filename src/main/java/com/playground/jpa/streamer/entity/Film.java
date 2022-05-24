package com.playground.jpa.streamer.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String rating;
}
