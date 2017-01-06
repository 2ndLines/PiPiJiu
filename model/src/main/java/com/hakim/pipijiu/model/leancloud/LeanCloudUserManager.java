package com.hakim.pipijiu.model.leancloud;

import com.hakim.pipijiu.model.manager.UserManager;
import com.hakim.pipijiu.model.entities.User;
import com.hakim.pipijiu.model.retrofit.HttpClient;

import rx.Observable;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2017/1/6 <br/>
 * Desc  :
 */
public class LeanCloudUserManager implements UserManager {
    private UserService service;
    public LeanCloudUserManager(){
        service = HttpClient.getInstance().createService(UserService.class);
    }

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
