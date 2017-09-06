package com.example.rxdemo.http;

import com.example.rxdemo.model.User;
import com.example.rxdemo.model.VideoUrl;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zhangxiaoliang on 2017/8/10.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("api/v1/user/loginByPhone")
    Observable<BaseEntity<User>> login(@Field("phone") String userId,
                                       @Field("pass") String password);

    @GET("video/getUrl")
    Observable<BaseEntity<VideoUrl>> getVideoUrl(@Query("id") long id);

    @FormUrlEncoded
    @POST("user/addVideo")
    Observable<BaseEntity<Boolean>> addVideo(@FieldMap Map<String,Object> map);

}
