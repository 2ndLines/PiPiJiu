package com.hakim.pipijiu.data.api.impl;

import com.hakim.pipijiu.data.api.UserApi;
import com.hakim.pipijiu.data.entities.User;

import rx.Observable;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/29 17:00 <br/>
 * Desc  :
 */
public class UserApiImpl implements UserApi {

    @Override
    public Observable<User> login(String phoneNumber, String password) {
        return null;
    }

    @Override
    public Observable<Boolean> signUp(String phoneNumber, String smsCode, String password) {
        return null;
    }

    @Override
    public Observable<User> getUser(String uid) {
        return null;
    }

    @Override
    public Observable<User> fetchMe() {
        return null;
    }

    @Override
    public Observable<User> refreshToken() {
        return null;
    }

    @Override
    public Observable<Boolean> requestSmsCode(String phoneNumber, String opType) {
        return null;
    }

    @Override
    public Observable<Boolean> verifySmsCode(String phoneNumber, String smsCode) {
        return null;
    }

    @Override
    public Observable<Boolean> requestSmsCodeToResetPassword(String phoneNumber) {
        return null;
    }

    @Override
    public Observable<Boolean> resetPassword(String smsCode, String newPassword) {
        return null;
    }

    @Override
    public Observable<User> updateUser(User entity) {
        return null;
    }
}
