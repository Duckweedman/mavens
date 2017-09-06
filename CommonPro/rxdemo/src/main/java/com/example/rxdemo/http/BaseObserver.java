package com.example.rxdemo.http;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by zhangxiaoliang on 2017/8/10.
 */

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {

    private static final String TAG = "BaseObserver";

    private Context mContext;

    protected BaseObserver(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        Log.i(TAG, "onSubscribe: ");
    }

    @Override
    public void onNext(@NonNull BaseEntity<T> tBaseEntity) {
        if (tBaseEntity.isSuccess()) {
            T t = tBaseEntity.getData();
            onHandleSuccess(t);
        } else {
            onHandleError(tBaseEntity.getMsg());
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        Log.i(TAG, "onError: " + e.toString());
    }

    @Override
    public void onComplete() {
        Log.i(TAG, "onComplete: ");
    }

    protected abstract void onHandleSuccess(T t);

    protected void onHandleError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
