package com.playground.jpa.inheritance4.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "CUSTOMER_ID")),
        @AttributeOverride(name = "name", column = @Column(name = "CUSTOMER_NAME"))
})
public class Customer extends BaseEntity{

    // ID 상속
    // NAME 상속
    private String email;
}
