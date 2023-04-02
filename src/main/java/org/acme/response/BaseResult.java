package org.acme.response;

import lombok.Data;

@Data
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
}
