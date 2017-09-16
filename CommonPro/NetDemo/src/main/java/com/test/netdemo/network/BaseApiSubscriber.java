package com.test.netdemo.network;


import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.test.netdemo.base.BaseBean;
import com.test.netdemo.BuildConfig;
import com.test.netdemo.MyApplication;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by meijunqiang on 2017/9/7 0007.
 * 描述：Present层中访问的回调接口
 */

public abstract class BaseApiSubscriber<T> implements Observer<BaseBean<T>> {

    public static final String TAG = "DataOpt";

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    /**
     * @param tBaseBean 对访问是否成功code的统一处理
     */
    @Override
    public void onNext(@NonNull BaseBean<T> tBaseBean) {
        if (BuildConfig.DEBUG) {
            Gson gson = new Gson();
            Log.d(TAG, gson.toJson(tBaseBean));
        }
        if (tBaseBean.isSuccess()) {
            onHandleSuccess(tBaseBean.data);
        } else {
            onHandleError(tBaseBean.msg);
        }
    }

    protected abstract void onHandleSuccess(T t);

    /**
     * @param errorStr 请求失败（两种情况：code异常或访问异常，这里是code异常）
     */
    protected void onHandleError(String errorStr) {
        Toast.makeText(MyApplication.getAppContext(), errorStr, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(@NonNull Throwable e) {
        Log.d(TAG, "onError:" + e.toString());
    }

    @Override
    public void onComplete() {
        int a=3;
    }
}
