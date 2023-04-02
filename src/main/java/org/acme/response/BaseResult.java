package org.acme.response;

import lombok.Data;

public class BaseResult<T> {

    private int code;

    private String msg;

    private T data;

    public BaseResult(int code) {
        this.code = code;
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static BaseResult<String> success() {
        return new BaseResult<>(200);
    }

    public static BaseResult<String> fail() {
        return new BaseResult<>(500);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
