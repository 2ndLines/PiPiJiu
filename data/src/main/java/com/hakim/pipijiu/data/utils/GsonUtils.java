package com.hakim.pipijiu.data.utils;

import com.google.gson.Gson;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/1 17:07 <br/>
 * Desc  :
 */
public class GsonUtils {
    private final static Gson gson = new Gson();

    public static <T>  String toJson(T t) {
        return gson.toJson(t);
    }

    public static  <R> R fromJson(String jsonString, Class<R> clazz) {
        return gson.fromJson(jsonString, clazz);
    }

}
