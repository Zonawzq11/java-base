package com.study.project.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserModel {
    @NotNull(message = "userId 不能为空")
    private Long userId;
    private String userName;
    private Integer age;
}
