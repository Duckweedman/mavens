package com.example.rxdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhangxiaoliang on 2017/8/10.
 */

public class User {


    @SerializedName("id")
    private long id;
    @SerializedName("token")
    private String token;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("nickname")
    private String nickname;

    public long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getNickname() {
        return nickname;
    }


}
