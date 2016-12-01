package com.hakim.pipijiu.data.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/30 14:19 <br/>
 * Desc  :
 */
public enum RetrofitClient {
    INSTANCE;
    private static final String BASE_URL = "https://api.leancloud.cn/1.1/";
    private final Retrofit retrofit;

    RetrofitClient() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:dd").create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OKHttpClient.INSTANCE.getClient())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
