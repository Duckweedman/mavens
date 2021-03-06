package com.example.rxdemo.http;

import com.example.rxdemo.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by zhangxiaoliang on 2017/8/10.
 */

public class UserTypeAdapter implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonObject()) {
            Gson gson = new Gson();
            return gson.fromJson(json, User.class);
        }
        return null;
    }
}
