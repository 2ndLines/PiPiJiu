package com.hakim.pipijiu.data.rest;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/29 16:45 <br/>
 * Desc  :
 */
public class LeanCloudInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request()
                .newBuilder()
                .addHeader("X-LC-Id", "1phFDb13NgorRUYU3DH8qPEJ-gzGzoHsz")
                .addHeader("X-LC-Key", "3vCikOfQxO82jgaORYpdzQpQ")
                .addHeader("Content-Type", "application/json")
                .build();

        return chain.proceed(newRequest);
    }
}
