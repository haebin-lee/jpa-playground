package com.playground.jpa.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.playground.jpa.member.model.RoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"}
)})
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 10)
    private String userName;

    private Integer age;

    @Embedded
    Period workPeriod;

    @Embedded
    Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY"))
            , @AttributeOverride(name = "street", column = @Column(name = "COMPANY_STREET"))
            , @AttributeOverride(name = "zipcode", column = @Column(name = "COMPANY_ZIPCODE"))
    })
    Address companyAddress;

    @Embedded
    PhoneNumber phoneNumber;

    // 값으로 사용하는 컬럼이 1개일 때 @Column 사용
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "FAVORITE_FOODS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    // 컬렉션의 경우
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ADDRESS_HISTORY", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    // 조인컬럼의 nullable=true 와 false에 따라 조인 정책이 달라진다.
    // nullable=true(default)의 경우에는 조인값이 없을 수도 있으므로 외부조인을
    // nullable=false의 경우에는 반드시 조인 값이 있으므로 내부조인을 사용한다.
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

//    @ManyToMany(cascade = CascadeType.ALL)// 다대다 : 사용자-상품
//    @JoinTable(name = "MEMBER_PRODUCT",
//            joinColumns = @JoinColumn(name = "MEMBER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
//    private List<Product> products = new ArrayList<>();

//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts;

    @JsonIgnore
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Orders> orders = new ArrayList<>();

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
