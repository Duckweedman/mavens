package com.test.netdemo.network;

import com.test.netdemo.base.BaseBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by meijunqiang on 2017/9/7 0007.
 * 描述：Retrofit接口定义
 */

public interface ApiService {
    /**
     * 获取版本号
     *
     * @return
     */
    @POST("api/v1/appversion/getVersion.htm")
    @FormUrlEncoded
    Observable<BaseBean<VersionBean>> getVersion(@FieldMap Map<String, String> params);
}
