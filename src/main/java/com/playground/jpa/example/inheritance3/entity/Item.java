package com.playground.jpa.inheritance3.entity;

import javax.persistence.*;

/*
 * 구현 클래스마다 테이블 전략
 * 장점
 * * 서브타입을 구분해서 처리할 때 효과적이다.
 * * not null 제약 조건을 사용할 수 있다.
 *
 * 단점
 * * 여러 자식 테이블을 함께 조회할 대 성능이 느리다.(SQL에 UNION을 사용해야한다.)
 * * 자식 테이블을 통합해 쿼리하기 어렵다.
 * 그러므로 상황에 따라서는 조회 성능이 오히려 느려질 수 있다.
 *
 * 특징
 * * 구분 컬럼을 사용하지 않는다.
 * * 데이터베이스 설계자와 ORM전문가 모두 추천하지 않는 전략이다.
 * */
/*
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;    // 이름
    private int price;      // 가격
}
 */
