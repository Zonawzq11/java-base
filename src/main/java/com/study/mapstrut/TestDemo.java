package com.study.mapstrut;


import cn.hutool.core.bean.BeanUtil;
import com.study.mapstrut.convert.UserConvert;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        System.out.println("---------------");

        User user = new User();
        user.setUserName("zhiqiang");
        user.setUserId(123L);



        System.out.println("---------------");
        UserChild userChild = new UserChild();
        userChild.setChildName("childName");
        user.setUserChild(userChild);
        user.setNumber("1234567899");
        UserCopy manyCopy = UserConvert.INSTANCE.toManyCopy(user);
        System.out.println(manyCopy.toString());


        System.out.println("BeanUtils---------------");
        UserCopy userCopy1 = new UserCopy();
        BeanUtil.copyProperties(user,userCopy1);
        System.out.println(userCopy1.toString());

        System.out.println("List---------------");
        List<User> users = new ArrayList<>();
        users.add(user);
        List<UserCopy> userCopies = UserConvert.INSTANCE.toListUserCopyList(users);
        System.out.println(userCopies.toString());
    }
}
