package com.taipu.jnitool;

/**
 * Created by meijunqiang on 2017/12/28  13:49.
 * 描述：AppSecretTool
 */

public class AppSecretTool {
    static {
        System.loadLibrary("taipujnitool");
    }
    public static native String getAppSecretStr();
}
