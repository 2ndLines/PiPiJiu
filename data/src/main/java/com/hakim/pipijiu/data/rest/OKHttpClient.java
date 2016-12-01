package com.hakim.pipijiu.data.rest;

import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/30 14:21 <br/>
 * Desc  :
 */
public enum OKHttpClient {
    INSTANCE;
    private final okhttp3.OkHttpClient client;
    OKHttpClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.tag("OKHttp").d(message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        client = new okhttp3.OkHttpClient.Builder()
                .addInterceptor(new LeanCloudInterceptor())
                .addInterceptor(loggingInterceptor)
                .build();
    }

    public okhttp3.OkHttpClient getClient(){
        return client;
    }
}
