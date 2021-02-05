package com.playground.jpa.member.entity;

import com.playground.jpa.member.model.RoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"}
)})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 10)
    private String userName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @Builder
    public Member(String userName, Integer age, Team team) {
        this.userName = userName;
        this.age = age;
        this.team = team;
    }

    public void setTeam(Team team) {
        if (this.team != null) {
            this.team.getMemberList().remove(this);
        }
        this.team = team;
        team.getMemberList().add(this);
    }

    public void updateUserNameAndTeamName(String userName, String teamName) {
        this.userName = userName;
        this.setTeam(new Team(teamName));
    }

}
