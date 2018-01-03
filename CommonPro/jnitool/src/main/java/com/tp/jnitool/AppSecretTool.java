package com.tp.jnitool;

/**
 * Created by meijunqiang on 2017/12/28  13:49.
 * 描述：AppSecretTool
 */

public class AppSecretTool {
    static {
        System.loadLibrary("tpjnitool");
    }
    public static native String getAppSecretStr();
}
