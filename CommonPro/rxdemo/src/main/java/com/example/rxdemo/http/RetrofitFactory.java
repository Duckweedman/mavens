package com.example.rxdemo.http;

import com.example.rxdemo.model.User;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
 * Created by zhangxiaoliang on 2017/8/10.
 */

public class RetrofitFactory {


    private static final String BASE_URL = "https://apinew.legendzest.cn/";
    private static final long TIMEOUT = 30;

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            // 添加通用的Header
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request.Builder builder = chain.request().newBuilder();
                    builder.addHeader("token", "123");
                    return chain.proceed(builder.build());
                }
            })
            //    这里可以添加一个HttpLoggingInterceptor，因为Retrofit封装好了从Http请求到解析，
            //    出了bug很难找出来问题，添加HttpLoggingInterceptor拦截器方便调试接口
            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {

                }
            }).setLevel(HttpLoggingInterceptor.Level.BASIC))
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build();


    private static APIService apiService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            //添加gson转换器
            .addConverterFactory(GsonConverterFactory.create(buildGson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(APIService.class);

    public static APIService getInstance() {
        return apiService;
    }

    private static Gson buildGson() {
        return new GsonBuilder()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .registerTypeAdapter(User.class, new UserTypeAdapter())
                .create();
    }


}
