package com.study.project.result;

import java.util.HashMap;
import java.util.Map;

public enum BusinessCodeEnum {
    DEFAULT_SUCCESS(2000000000, "default success"),
    DEFAULT_SYS_ERROR(2000000999, "系统错误"),
    CHECK_PARAM_NO_RESULT(2000000100, "检测参数无结果"),
    CHECK_BIZ_NO_RESULT(2000000101, "检查业务无结果"),
    CHECK_ACTION_NO_RESULT(2000000102, "检查执行情况无结果");

    private static final Map<Integer, BusinessCodeEnum> codeMap = new HashMap((int)((double)values().length / 0.75D) + 1);
    private int code;
    private String msg;

    public static BusinessCodeEnum valueOfCode(int code) {
        return (BusinessCodeEnum)codeMap.get(code);
    }

    private BusinessCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    static {
        BusinessCodeEnum[] var0 = values();
        int var1 = var0.length;
        for(int var2 = 0; var2 < var1; ++var2) {
            BusinessCodeEnum businessCodeEnum = var0[var2];
            codeMap.put(businessCodeEnum.getCode(), businessCodeEnum);
        }

    }
    public static void main(String[] args) {
        System.out.println(codeMap.get(BusinessCodeEnum.CHECK_ACTION_NO_RESULT.getCode()).getMsg());
    }
}
