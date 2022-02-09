package com.ypk.swagger.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yangpk
 * @date 2021/6/20
 */
@ApiModel(value = "结果对象")
@Data
@AllArgsConstructor
public class Result<T> {

    private static final String successMsg = "请求成功";
    private static final String failMsg = "请求失败";

    private int status;

    private String message;

    private T data;


    public static <T> Result<T> successResponse() {
        return new Result<T>(200, successMsg, null);
    }

    public static <T> Result<T> successResponse(T data) {
        return new Result<T>(200, successMsg, data);
    }

    public static <T> Result<T> failResponse() {
        return new Result<T>(-1, failMsg, null);
    }

    public static <T> Result<T> failResponse(int status, T data) {
        return new Result<T>(status, failMsg, data);
    }

    public static <T> Result<T> failResponse(String message, T data) {
        return new Result<T>(-1, message, data);
    }

    public static <T> Result<T> failResponse(int status, String message, T data) {
        return new Result<T>(status, message, data);
    }
}
