package com.playground.jpa.inheritance2.entity;

import javax.persistence.*;
/*
 * 단일 테이블 전략
 * 장점
 * * 조인이 필요없으므로 일반적으로 조회 성능이 빠르다.
 * * 조회쿼리가 단순하다.
 *
 * 단점
 * * 자식 엔티티가 매핑한 컬럼은 모두 null을 허용해야한다.
 * * 단일 테이블에 모든 것을 저장하므로 테이블이 커질 수 있다.
 * 그러므로 상황에 따라서는 조회 성능이 오히려 느려질 수 있다.
 *
 * 특징
 * * 구분 컬럼을 반드시 사용해야한다. 따라서 @DiscriminatorColumn을 꼭 설정해야한다.
 * * @DiscriminatorValue를 지정하지 않으면 기본으로 엔티티 이름을 사용한다. (예-Movie, Album, Book)
 * */
/*
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;

    private String artist;
    private String director;
    private String actor;s
    private String author;
    private String isbn;
}
*/