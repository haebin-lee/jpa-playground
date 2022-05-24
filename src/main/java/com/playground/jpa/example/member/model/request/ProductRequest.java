package com.playground.jpa.example.member.model.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class ProductRequest {

    @NotBlank
    @Size(max = 255)
    private String name;
}
