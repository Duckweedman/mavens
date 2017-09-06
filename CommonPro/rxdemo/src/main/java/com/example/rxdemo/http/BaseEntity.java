package com.example.rxdemo.http;

import com.google.gson.annotations.SerializedName;

/**
 * 服务器返回数据格式
 * Created by zhangxiaoliang on 2017/8/10.
 */

public class BaseEntity<T> {

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private T data;

    public boolean isSuccess() {
        return code == 0;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    public T getData() {
        return data;
    }


}
