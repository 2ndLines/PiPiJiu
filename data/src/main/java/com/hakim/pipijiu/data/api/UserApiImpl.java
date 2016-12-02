package com.hakim.pipijiu.data.api;

import com.hakim.pipijiu.data.entities.UserEntity;
import com.hakim.pipijiu.data.retrofit.RetrofitApi;
import com.hakim.pipijiu.data.retrofit.RetrofitClient;
import com.hakim.pipijiu.data.rest.UserRest;

import java.util.Locale;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import rx.Observable;
import rx.functions.Func1;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/29 17:00 <br/>
 * Desc  :
 */
public class UserApiImpl implements UserApi, RetrofitApi {
    private static final String TAG = "UserApi";
    private final UserRest userRest;
    private static final Func1<ResponseBody, Boolean> BOOLEAN_MAPPER = new Func1<ResponseBody, Boolean>() {
        @Override
        public Boolean call(ResponseBody body) {
            return body != null;
        }
    };

    public UserApiImpl() {
        userRest = RetrofitClient.getInstance().create(UserRest.class);
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


        Call<UserEntity> call = userRest.createUser(buildBody(body));
        return doRequest(call, null);
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
        Call<ResponseBody> call = userRest.requestSmsCode(buildBody(body));

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

    @Override
    public <T> RequestBody buildBody(T t) {
        return RetrofitClient.getInstance().buildBody(t);
    }

    @Override
    public <T, R> Observable<R> doRequest(Call<T> call, Func1<T, R> mapper) {
        return RetrofitClient.getInstance().doRequest(call, mapper);
    }
}
