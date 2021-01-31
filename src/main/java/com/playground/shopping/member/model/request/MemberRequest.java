package com.playground.shopping.member.model.request;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class MemberRequest {

    @NotBlank
    @Max(value = 255, message = "255자를 넘을 수 없습니다.")
    private String userName;

    @NotNull
    private Integer age;

}
