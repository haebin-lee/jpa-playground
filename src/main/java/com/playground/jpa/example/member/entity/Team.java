package com.playground.jpa.example.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "team") // mappedBy는 양방향 매핑일 때 사용하는데 반대쪽 매핑의필드 이름을 값으로 주면 된다.
    private List<Member> memberList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
}
