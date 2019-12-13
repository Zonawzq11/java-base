package com.study.spring.aop;

import com.study.exception.ServiceException;
import com.study.project.result.BusinessCodeEnum;
import com.study.project.result.CallResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @ClassName AspectJ
 * @Description Component层切面
 * @Author wuqinghai01
 * @Date 2019/11/5 14:43
 * Version 1.0
 */
@Aspect
@Component
public class AspectException {
    private Logger logger = Logger.getLogger(getClass().getName());
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Pointcut("within(com.study.project.service.*)")
    public void exception() {
    }

    @Around("exception()")
    public CallResult AroundProcess(ProceedingJoinPoint joinPoint) {
       // logger.info("SCF请求方法:{}.{},入参:{}", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), JSONObject.toJSONString(joinPoint.getArgs()));
        CallResult response = null;
        try {
            response = (CallResult) joinPoint.proceed();
           // logger.info("SCF请求方法:{}.{},返回值:{}", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), JSONPObject.toJSONString(response));
            return response;
        }catch (ServiceException e){
           // logger.info("{}.{}接口调用业务异常", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName());
            return CallResult.fail(e.getCode(),e.getErrorMsg(),e.getMessage());
        } catch (Throwable e) {
            logger.info("{}.{}接口调用异常"+ joinPoint.getTarget().getClass().getSimpleName()+joinPoint.getSignature().getName()+ e);
            return CallResult.fail(BusinessCodeEnum.DEFAULT_SYS_ERROR.getCode(),BusinessCodeEnum.DEFAULT_SYS_ERROR.getMsg() ,e.getMessage());
        }
    }

}
