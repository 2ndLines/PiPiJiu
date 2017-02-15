package com.hakim.pipijiu.model.leancloud;

import android.support.annotation.NonNull;

import com.hakim.pipijiu.model.utils.GsonUtils;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/30 14:19 <br/>
 * Desc  :
 */
public class RetrofitClient {
    private static RetrofitClient INSTANCE;
    public static RetrofitClient getInstance() {
        if (INSTANCE == null){
            INSTANCE = new RetrofitClient();
        }
        return INSTANCE;
    }

    public <T> RequestBody buildBody(T t) {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonUtils.toJson(t));
    }

    public <T> Observable<Boolean> doRequestForBoolean(Call<T> call) {
        return doRequest(call, new Func1<T, Boolean>() {
            @Override
            public Boolean call(T t) {
                return t != null;
            }
        });
    }

    /**
     * 执行LeanCloud的REST请求。<br/>
     * 如果参数{@code mapper}为null，则T类型与R类型必须为同一类型，否则将出现类型转换异常。
     *
     * @param call   Call实例
     * @param mapper 将T类型转换为R的类型
     * @param <T>    Call的返回类型
     * @param <R>    期望的结果类型
     * @return
     */
    public <T, R> Observable<R> doRequest(final Call<T> call, final Func1<T, R> mapper) {
        if (call == null) throw new NullPointerException("Call object must not be null");
        return Observable.create(new Observable.OnSubscribe<R>() {
            @Override
            public void call(Subscriber<? super R> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    try {
                        Response<T> r = call.execute();
                        if (r.errorBody() != null) {
                            String errStr = r.errorBody().string();
                            LeanCloudError error = GsonUtils.fromJson(errStr, LeanCloudError.class);
                            subscriber.onError(new LeanCloudException(error.getCode(), error.getError()));
                        } else if (r.isSuccessful()) {
                            T tmp = r.body();
                            R r1 = null;
                            if (mapper != null) {
                                r1 = mapper.call(tmp);
                            } else {
                                r1 = (R) tmp;
                            }
                            subscriber.onNext(r1);
                            subscriber.onCompleted();
                        } else {
                            subscriber.onError(new LeanCloudException(r.code(), r.message()));
                        }
                    } catch (IOException e) {
                        subscriber.onError(e);
                    }
                }
            }
        }).subscribeOn(Schedulers.io());
    }

    public <T> Observable<T> request(@NonNull final Call<ResponseBody> call, @NonNull final Type typeOfT){
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    LeanCloudException exception = null;
                    try {
                        Response<ResponseBody> response = call.execute();
                        if (response.errorBody() != null){
                            LeanCloudError error = GsonUtils.fromJson(response.errorBody().string(), LeanCloudError.class);
                            exception = new LeanCloudException(error.getCode(),error.getError());
                        }else if (response.isSuccessful()){
                            T t = GsonUtils.fromJson(response.body().string(), typeOfT);
                            System.out.println("Request result : " + t);
                            subscriber.onNext(t);
                            subscriber.onCompleted();
                        }else {
                            exception = new LeanCloudException(response.code(),response.message());
                        }

                    } catch (IOException e) {
                        exception = new LeanCloudException(LeanCloudException.CODE_REQUEST_EXCEPTION, e.getMessage());
                    }
                    if (exception != null){
                        subscriber.onError(exception);
                    }
                }
            }
        }).subscribeOn(Schedulers.io());
    }

    public Observable<ServiceResult> doRequest(@NonNull final Call<ServiceResult> call) {
        return Observable.create(new Observable.OnSubscribe<ServiceResult>() {
            @Override
            public void call(Subscriber<? super ServiceResult> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    try {
                        Response<ServiceResult> r = call.execute();
                        if (r.errorBody() != null) {
                            String errStr = r.errorBody().string();
                            LeanCloudError error = GsonUtils.fromJson(errStr, LeanCloudError.class);
                            subscriber.onError(new LeanCloudException(error.getCode(), error.getError()));
                        } else if (r.isSuccessful()) {
                            ServiceResult result = r.body();
                            System.out.println("Request Result : " + result);
                            subscriber.onNext(result);
                            subscriber.onCompleted();
                        } else {
                            subscriber.onError(new LeanCloudException(r.code(), r.message()));
                        }
                    } catch (IOException e) {
                        subscriber.onError(e);
                    }
                }
            }
        }).subscribeOn(Schedulers.io());
    }

}
