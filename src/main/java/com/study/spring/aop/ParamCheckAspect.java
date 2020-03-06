package com.study.spring.aop;


import com.alibaba.fastjson.JSON;
import com.study.annotation.CheckParam;
import com.study.exception.ServiceException;
import com.study.project.result.BusinessCodeEnum;
import com.study.utils.AspectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 参数校验 ParamCheckAspect 切面
 */
@Aspect
@Component
@Slf4j
public class ParamCheckAspect {
    @Autowired
    private Validator validator;

    @Around(value = "@annotation(checkParam)")
    @Order(value = 1)
    public synchronized void doAround(ProceedingJoinPoint joinPoint, CheckParam checkParam) {
        try {
            //1.获取到所有的参数值的数组
            Object[] args = joinPoint.getArgs();
            String processName = AspectUtil.getClassAddMethodName(joinPoint);
            //1.打印入参
            log.info("{} 入参: {}", processName, JSON.toJSONString(args));
            //2.参数校验
            Set<ConstraintViolation<Object[]>> validate = validator.validate(args);
            if(validate == null || validate.isEmpty()){
                 new ServiceException(BusinessCodeEnum.CHECK_PARAM_NO_RESULT.getCode(),BusinessCodeEnum.CHECK_PARAM_NO_RESULT.getMsg(), "");
            }
            Set<String> msgs = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
            if (!CollectionUtils.isEmpty(msgs)){
                //验证失败
                String msg = String.join(";", msgs.toArray(new String[msgs.size()]));
                 new ServiceException(BusinessCodeEnum.CHECK_PARAM_NO_RESULT.getCode(), msg, msg);
            }
            //3.打印出参
            Object object = null;
            object = joinPoint.proceed();
            log.info("{} 出参: {}", processName, JSON.toJSONString(object));
        }catch (Throwable throwable){
            log.error("参数校验失败:{}",throwable);
        }
    }


}
