package com.playground.jpa.inheritance4.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/*
* @MappedSuperclass 의 특징
* * 테이블과 매핑되지 않고 자식 클래스에 엔티티의 매핑정보를 상속하기 위해 사용된다.
* * @MappedSuperclass로 지정한 클래스는 엔티티가 아니므로 em.find()나 JPQL에서 사용할 수 없다.
* * 이 클래스는 직접 생성해서 사용할일이 거의 없으므로 추상클래스로 만드는 것을 권장한다.
* */
@MappedSuperclass
public abstract class BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;
}
