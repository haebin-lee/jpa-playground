package com.playground.jpa.inheritance.entity;

import lombok.Getter;

import javax.persistence.*;

/*
* 조인전략
* 장점
* * 테이블이 정규화된다.
* * 외래키 참조 무결성 제약 조건을 활용할 수 있다.
* * 저장공간을 효율적으로 사용한다.
*
* 단점
* * 조회할 때 조인이 많이 사용되므로 성능이 저하될 수 있다.
* * 조회 쿼리가 복잡하다.
* * 데이터를 등록할 때 SQL이 두번 실행한다.
*
* 특징
* * JPA 표준 명세는 구분 컬럼을 사용하도록 하지만 하이버네이트를 포함한 몇몇 구현체는 구분컬럼(@DiscriminatorColumn)없이도 동작한다.
* * 관련 어노테이션 @PrimaryKeyJoinColumn, @DiscriminatorColumn, @DiscriminatorValue
* */
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // 상속맵핑: 조인전략
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
}
