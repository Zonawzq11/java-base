package com.study.project.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;


@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CallResult<T>  implements Serializable {
    //请求返回码
    private int code;
    //请求返回的toast  的提示
    private String message;
    //错误的详细信息 包括异常的详细描述
    private String desc;
    //请求的返回实体（正常返回的时候才会返回）
    private T result;
    //构造方法
    public CallResult() {
    }

    public CallResult(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public CallResult(int code, String message,String  desc ,T result) {
        this.code = code;
        this.message = message;
        this.desc = desc;
        this.result = result;
    }

    /**
     * success 方法
     * @param <T>
     * @return
     */
    public  static  <T>CallResult<T> success(){
        return    new CallResult(BusinessCodeEnum.DEFAULT_SUCCESS.getCode(),BusinessCodeEnum.DEFAULT_SUCCESS.getMsg(),null);
    }

    public  static  <T>CallResult<T> success(T result){
        return    new CallResult(BusinessCodeEnum.DEFAULT_SUCCESS.getCode(),BusinessCodeEnum.DEFAULT_SUCCESS.getMsg(),result);
    }

    /**
     * fail
     * @param <T>
     * @return
     */
    public static <T> CallResult<T> fail() {
        return new CallResult(BusinessCodeEnum.DEFAULT_SYS_ERROR.getCode(), BusinessCodeEnum.DEFAULT_SYS_ERROR.getMsg(), (Object)null);
    }

    public static <T> CallResult<T> fail(T result) {
        return new CallResult(BusinessCodeEnum.DEFAULT_SYS_ERROR.getCode(), BusinessCodeEnum.DEFAULT_SYS_ERROR.getMsg(), result);
    }

    public static <T> CallResult<T> fail(int code, String message , String desc) {
        return new CallResult(code, message,desc,(Object) null);
    }

    public boolean isSuccess() {
        return this.code == BusinessCodeEnum.DEFAULT_SUCCESS.getCode();
    }

}
