package com.study.exception;

public class ServiceException extends  RuntimeException {
    private int code;
    private String errorMsg;

    private ServiceException(String msg){
        super(msg);
    }

    public ServiceException(int code,String errorMsg ,String msg){
        super(msg);
        this.code = code;
        this.errorMsg = errorMsg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static void main(String[] args) {
        try {
            throw new ServiceException("这是一个自定义异常");
        }catch (ServiceException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }



}
