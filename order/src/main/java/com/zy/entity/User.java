package com.zy.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class User {

    @NotBlank(message = "用户名不能为空")
    private String name;

    private String password;
}
