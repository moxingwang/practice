package com.mo.demo.common.common;

import java.io.Serializable;

/**
 * @author MoXingwang on 2018/1/27.
 */
public class Result<T> implements Serializable {
    private int code = 200;
    private String message;
    private T data;

    public Result() {
    }

    public static Result success(){
        return new Result(200,"成功");
    }

    public static <T> Result success(T data){
        return new Result(200,"成功",data);
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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
}
