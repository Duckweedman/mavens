package com.test.netdemo.network;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by meijunqiang on 2017/9/7 0007.
 * 描述：网络请求管理类
 */
public class Zygote {
    private static final String BASE_APP_API = "https://app.33etong.com/";
    private static final long TIMEOUT = 30;
    /**
     * Okhttp客户端
     */
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            // 添加通用的Header
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request.Builder builder = chain.request().newBuilder();
                    builder.addHeader("platform", "1");
                    //TODO:meiyizhi 需要传入实际Token
                    builder.addHeader("token", "2");
                    return chain.proceed(builder.build());
                }
            })
            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.d(BaseApiSubscriber.TAG, message);
                }
            }).setLevel(HttpLoggingInterceptor.Level.BASIC))
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build();
    /**
     * User请求构造
     */
    public static ApiService apiService = new Retrofit.Builder()
            .baseUrl(BASE_APP_API)
            //添加gson转换器
            .addConverterFactory(GsonConverterFactory.create())
            //TODO:meiyizhi 当需要加密时，使用下面的转换器
//            .addConverterFactory(MyGsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(ApiService.class);
}
