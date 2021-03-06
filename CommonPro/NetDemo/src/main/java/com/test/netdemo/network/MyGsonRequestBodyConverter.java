package com.test.netdemo.network;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by meijunqiang on 2017/10/11 0011 15:50.
 * 描述：统一加密方式,和注解进行配合
 */

public class MyGsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType
            .parse("application/json; charset=UTF-8");
    static final Charset UTF_8 = Charset.forName("UTF-8");

    final Gson gson;
    final TypeAdapter<T> adapter;

    MyGsonRequestBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
        System.out.println("#IRequestBodyConverter初始化#");
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        String json = value.toString();
        System.out.println("#加密前#" + json);
//        json = AesEncryptionUtil.encrypt(json);
        System.out.println("#加密后#" + json);
        return RequestBody.create(MEDIA_TYPE, json);
    }
//    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
//    private Gson gson;
//    private final TypeAdapter<T> adapter;
//    public MyGsonRequestBodyConverter(Gson gson, TypeAdapter<T> adapter) {
//        this.gson = gson;
//        this.adapter = adapter;
//    }
//
//    @Override
//    public RequestBody convert(T value) throws IOException {
//        //加密
//        APIBodyData data = new APIBodyData();
//        Logout.log("xiaozhang", "request中传递的json数据：" + value.toString());
//        data.setData(value.toString());
//        String postBody = gson.toJson(data); //对象转化成json
//        Logout.log("xiaozhang", "转化后的数据：" + postBody);
//        return RequestBody.create(MEDIA_TYPE, postBody);
//    }
}
