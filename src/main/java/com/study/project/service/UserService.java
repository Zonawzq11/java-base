package com.study.project.service;

import com.study.annotation.CheckParam;
import com.study.exception.ServiceException;
import com.study.project.model.UserModel;
import com.study.project.result.BusinessCodeEnum;
import com.study.project.result.CallResult;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

@Service
public class UserService {
    @CheckParam
    public CallResult getUserInfo(UserModel userModel) {
        HashMap<String, String> resultMaping = new HashMap<String, String>();
        resultMaping.put("name", "wangzhiqiang");
        resultMaping.put("age", "30");
        resultMaping.put("address", "北京市朝阳区");
        throw  new ServiceException(BusinessCodeEnum.DEFAULT_SYS_ERROR.getCode(),BusinessCodeEnum.DEFAULT_SYS_ERROR.getMsg(),"系统错误了");
    //    return  CallResult.success(resultMaping);
    }
}
