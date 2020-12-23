package com.playground.shopping.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(length = 256, nullable = false)
    private String username;

    private Integer age;

    @Builder
    public Member(String username, Integer age){
        this.username = username;
        this.age = age;
    }

}
