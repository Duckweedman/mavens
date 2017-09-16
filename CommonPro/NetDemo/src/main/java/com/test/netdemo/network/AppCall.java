package com.test.netdemo.network;

import com.test.netdemo.MyApplication;
import com.test.netdemo.base.BaseBean;

import java.util.HashMap;

/**
 * Created by meijunqiang on 2017/9/7 0007.
 * 描述：对访问的最上层封装，过滤掉访问配置项，对外暴露统一接口调用
 * 重要：调用者应当是Present，从而回调View进行数据展示
 */

public class AppCall {
    public static AppCall sAppCall;

    /**
     * 获取请求单例
     *
     * @return
     */
    public static AppCall obtain() {
        if (sAppCall == null) {
            sAppCall = new AppCall();
        }
        return sAppCall;
    }
    /**
     * 获取版本号
     */
    public void getVersion(BaseApiSubscriber subscriber) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "1");
        Zygote.apiService.getVersion(params)
                .compose(MyApplication.getApplication().<BaseBean<VersionBean>>bindToLifecycle())
                .subscribe(subscriber);

    }
}
