package com.test.netdemo.base;

import java.io.Serializable;

/**
 * Created by meijunqiang on 2017/9/7 0007.
 * 描述：所有数据结构的基类，方便数据携带
 */

public class BaseBean<T> implements Serializable {
    public String returnCode;
    private boolean secure;
    public String msg;
    public T data;
    public boolean result;

    /**
     * code请求判断
     * @return
     */
    public boolean isSuccess() {
        return returnCode.equals("200");
    }
}
