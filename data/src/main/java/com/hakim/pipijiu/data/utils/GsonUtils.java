package com.hakim.pipijiu.data.utils;

import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/1 17:07 <br/>
 * Desc  :
 */
public class GsonUtils {
    private final static Gson gson = new Gson();

    /**
     * 对象转json字串
     *
     * @param t   实体对象
     * @param <T> 对象类型
     * @return json字串
     */
    public static <T> String toJson(@NonNull T t) {
        return gson.toJson(t);
    }

    /**
     * json字串转实体对象
     *
     * @param json  json字串
     * @param clazz 对象类名
     * @param <R>   对象类型
     * @return 对象
     */
    public static <R> R fromJson(@NonNull String json, @NonNull Class<R> clazz) {
        return gson.fromJson(json, clazz);
    }

    /**
     * json字串转实体对象
     *
     * @param json 字串
     * @param type 对象类型包装
     * @param <R>  对象类型
     * @return 对象
     */
    public static <R> R fromJson(@NonNull String json, @NonNull Type type) {
        return gson.fromJson(json, type);
    }
}
