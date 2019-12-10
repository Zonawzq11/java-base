package com.study.project.result;

import java.io.Serializable;



public class CallResult<T>  implements Serializable {
    private int code;
    private String message;
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    //构造方法


    public CallResult() {
    }

    public CallResult(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    //success 方法
    public  static  <T>CallResult<T> success(){
        return    new CallResult(BusinessCodeEnum.DEFAULT_SUCCESS.getCode(),BusinessCodeEnum.DEFAULT_SUCCESS.getMsg(),null);
    }
    public  static  <T>CallResult<T> success(T result){
        return    new CallResult(BusinessCodeEnum.DEFAULT_SUCCESS.getCode(),BusinessCodeEnum.DEFAULT_SUCCESS.getMsg(),result);
    }
    // fail 方法
    public static <T> CallResult<T> fail() {
        return new CallResult(BusinessCodeEnum.DEFAULT_SYS_ERROR.getCode(), BusinessCodeEnum.DEFAULT_SYS_ERROR.getMsg(), (Object)null);
    }

    public static <T> CallResult<T> fail(T result) {
        return new CallResult(BusinessCodeEnum.DEFAULT_SYS_ERROR.getCode(), BusinessCodeEnum.DEFAULT_SYS_ERROR.getMsg(), result);
    }

    public static <T> CallResult<T> fail(int code, String message) {
        return new CallResult(code, message, (Object)null);
    }

    public static <T> CallResult<T> fail(int code, String message, T result) {
        return new CallResult(code, message, result);
    }

    public boolean isSuccess() {
        return this.code == BusinessCodeEnum.DEFAULT_SUCCESS.getCode();
    }

}
