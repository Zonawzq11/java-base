package com.study.mapstrut;

import lombok.*;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
@Data
@ToString
public class User {
    private Long userId;
    private String  userName;
    private String  number;
    private  UserChild userChild;

}
