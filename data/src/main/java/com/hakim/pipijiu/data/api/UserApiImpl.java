package com.hakim.pipijiu.data.api;

import com.google.gson.Gson;
import com.hakim.pipijiu.data.GsonUtils;
import com.hakim.pipijiu.data.entities.UserEntity;
import com.hakim.pipijiu.data.rest.ApiFactory;
import com.hakim.pipijiu.data.rest.LeanCloudError;
import com.hakim.pipijiu.data.rest.RestException;
import com.hakim.pipijiu.data.rest.UserReqBody;
import com.hakim.pipijiu.data.rest.UserRest;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

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
 * Date  : 2016/11/29 17:00 <br/>
 * Desc  :
 */
public class UserApiImpl implements UserApi {
    private static final String TAG = "UserApi";
    private final UserRest userRest;
    private static final Func1<ResponseBody, Boolean> BOOLEAN_MAPPER = new Func1<ResponseBody, Boolean>() {
        @Override
        public Boolean call(ResponseBody body) {
            return body != null;
        }
    };

    public UserApiImpl() {
        userRest = ApiFactory.INSTANCE.getUserRest();
    }


    @Override
    public Observable<UserEntity> login(String phoneNumber, String password) {
        return null;

    }

    public Observable<UserEntity> createUser(String username, String password) {
        final UserReqBody body = UserReqBody.newBuilder()
                .username(username)
                .password(password)
                .build();

        Call<UserEntity> call = userRest.createUser(buildRequestBody(body));
        return doRequest(call, null);
    }

    private static <T> RequestBody buildRequestBody(T t) {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonUtils.toJson(t));
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
    private <T, R> Observable<R> doRequest(final Call<T> call, final Func1<T, R> mapper) {
        if (call == null) throw new NullPointerException("Call object must not be null");
        return Observable.create(new Observable.OnSubscribe<R>() {
            @Override
            public void call(Subscriber<? super R> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    try {
                        Response<T> r = call.execute();
                        if (r.errorBody() != null) {
                            String errStr = r.errorBody().string();
                            LeanCloudError error = new Gson().fromJson(errStr, LeanCloudError.class);
                            subscriber.onError(new RestException(error.getCode(), error.getError()));
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
                            subscriber.onError(new RestException(r.code(), r.message()));
                        }
                    } catch (IOException e) {
                        subscriber.onError(e);
                    }
                }
            }
        }).subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<UserEntity> signUp(String phoneNumber, String smsCode, String password) {
        UserReqBody body = UserReqBody.newBuilder()
                .mobilePhoneNumber(phoneNumber)
                .smsCode(smsCode)
                .password(password)
                .build();
        return null;
    }

    @Override
    public Observable<Boolean> requestSmsCode(String phoneNumber, String opType) {
        UserReqBody body = UserReqBody.newBuilder()
                .mobilePhoneNumber(phoneNumber)
                .op(opType).build();
        Call<ResponseBody> call = userRest.requestSmsCode(buildRequestBody(body));
        return doRequest(call, BOOLEAN_MAPPER);
    }

    @Override
    public Observable<Boolean> verifySmsCode(String phoneNumber, String smsCode) {
        String str = String.format(Locale.getDefault(), "%s?mobilePhoneNumber=%s", smsCode, phoneNumber);
        System.out.println(str);
        return null;
    }

    @Override
    public Observable<Boolean> requestSmsCodeToResetPassword() {
        return null;
    }

    @Override
    public Observable<Boolean> resetPassword(String smsCode, String newPassword) {
        return null;
    }

    @Override
    public Observable<Boolean> updateUser(Map<String, String> fieldMap) {
        return null;
    }

    /**
     * @param <R> REST返回的结果
     */
    private interface RestCall<R> {

        Call<R> call();
    }
}
