package com.study.mapstrut;


import lombok.Data;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
@Data
public class UserCopy{
    private Long userId;
    private String userName;
    private Long  copyNumber;
    private UserChild userChild;

}
