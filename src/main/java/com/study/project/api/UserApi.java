package com.study.project.api;

import com.study.project.model.UserModel;
import com.study.project.result.CallResult;
import com.study.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/user")
public class UserApi {
    @Autowired
    UserService  userService;
    @RequestMapping("/v1/getUserInfo")
   public CallResult getUserInfo(Long  userId){
        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        return userService.getUserInfo(userModel);
   }
}
