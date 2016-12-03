package com.hakim.pipijiu.data.api;

import com.hakim.pipijiu.data.entities.UserEntity;
import com.hakim.pipijiu.data.rest.UserRest;
import com.hakim.pipijiu.data.rest.UserRestBody;
import com.hakim.pipijiu.data.retrofit.LeanCloudCache;
import com.hakim.pipijiu.data.retrofit.RetrofitApi;
import com.hakim.pipijiu.data.retrofit.RetrofitClient;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import rx.Observable;
import rx.functions.Action1;
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
        return doRequest(userRest.login(phoneNumber, password))
                .doOnNext(new Action1<UserEntity>() {
                    @Override
                    public void call(UserEntity entity) {
                        cacheTokenAndUid(entity);
                    }
                });
    }

    public Observable<UserEntity> createUser(String username, String password) {
        UserRestBody body = UserRestBody.newBuilder()
                .username(username)
                .password(password)
                .build();

        Call<UserEntity> call = userRest.createUser(body);
        return doRequest(call);
    }


    @Override
    public Observable<UserEntity> signUp(String phoneNumber, String smsCode, String password) {
        UserRestBody body = UserRestBody.newBuilder()
                .mobilePhoneNumber(phoneNumber)
                .smsCode(smsCode)
                .password(password)
                .build();
        return doRequest(userRest.signUp(body));
    }

    private void cacheTokenAndUid(UserEntity entity) {
        LeanCloudCache cache = LeanCloudCache.getInstance();
        cache.setToken(entity.getToken());
        cache.setObjectId(entity.getUid());
    }

    @Override
    public Observable<Boolean> requestSmsCode(String phoneNumber, String opType) {
        UserRestBody body = UserRestBody.newBuilder()
                .mobilePhoneNumber(phoneNumber)
                .op(opType)
                .build();
        return doRequest(userRest.requestSmsCode(body), BOOLEAN_MAPPER);
    }

    @Override
    public Observable<Boolean> verifySmsCode(String phoneNumber, String smsCode) {
        return doRequest(userRest.verifySmsCode(smsCode, phoneNumber), BOOLEAN_MAPPER);
    }

    @Override
    public Observable<Boolean> requestSmsCodeToResetPassword(String phoneNumber) {
        UserRestBody body = UserRestBody.newBuilder()
                .mobilePhoneNumber(phoneNumber)
                .build();
        return doRequest(userRest.requestSmsCodeToResetPassword(body), BOOLEAN_MAPPER);
    }

    @Override
    public Observable<Boolean> resetPassword(String smsCode, String newPassword) {
        UserRestBody body = UserRestBody.newBuilder()
                .password(newPassword)
                .build();
        return doRequest(userRest.resetPassword(smsCode, body), BOOLEAN_MAPPER);
    }

    @Override
    public Observable<UserEntity> updateUser(UserEntity entity) {
        LeanCloudCache cache = LeanCloudCache.getInstance();
        String token = cache.getToken();
        String uid = cache.getObjectId();
        return doRequest(userRest.updateUser(token, uid, entity), BOOLEAN_MAPPER)
                .map(new Func1<Boolean, UserEntity>() {
                    @Override
                    public UserEntity call(Boolean updated) {
                        // TODO: 2016/12/2 update user cache
                        return null;
                    }
                });
    }

    @Override
    public <T> RequestBody buildBody(T t) {
        return RetrofitClient.getInstance().buildBody(t);
    }

    @Override
    public <T, R> Observable<R> doRequest(Call<T> call, Func1<T, R> mapper) {
        return RetrofitClient.getInstance().doRequest(call, mapper);
    }

    @Override
    public <T> Observable<T> doRequest(Call<T> call) {
        return RetrofitClient.getInstance().doRequest(call);
    }
}
