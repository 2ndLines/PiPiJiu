package com.hakim.pipijiu.model.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/30 14:21 <br/>
 * Desc  :
 */
public class HttpClient {
    private static final String BASE_URL = "https://api.leancloud.cn/1.1/";
    private final Retrofit retrofit;

    private static class HOLDER {
        private static final HttpClient INSTANCE = new HttpClient();
    }

    public static HttpClient getInstance() {
        return HOLDER.INSTANCE;
    }

    HttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Timber.tag("OKHttp").d(message);
                    }
                });

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Interceptor headersInterceptor = new Interceptor() {
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
        };

        OkHttpClient client = new okhttp3.OkHttpClient.Builder()
                .addInterceptor(headersInterceptor)
                .addInterceptor(loggingInterceptor)
                .build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public <T> T createService(Class<T> clazz) {
        return this.retrofit.create(clazz);
    }

}
