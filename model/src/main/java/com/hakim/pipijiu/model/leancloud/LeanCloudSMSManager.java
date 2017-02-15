package com.hakim.pipijiu.model.leancloud;

import com.hakim.pipijiu.model.manager.SMSManager;
import com.hakim.pipijiu.model.entities.User;

import rx.Observable;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2017/1/6 <br/>
 * Desc  :
 */
public class LeanCloudSMSManager implements SMSManager {
    private final SmsService service;
    public LeanCloudSMSManager(){
        service = HttpClient.getInstance().createService(SmsService.class);
    }

    @Override
    public Observable<Boolean> requestSmsCode(String phoneNumber) {
        return null;
    }

    @Override
    public Observable<Boolean> verifySmsCode(String phoneNumber, String smsCode) {
        return null;
    }

    @Override
    public Observable<User> signInByPhone(String phoneNumber, String smsCode, String password) {
        return null;
    }

    @Override
    public Observable<Boolean> requestMobilePhoneVerify(String phoneNumber) {
        return null;
    }

    @Override
    public Observable<Boolean> verifyMobilePhone(String smsCode) {
        return null;
    }

    @Override
    public Observable<User> loginByMobilePhone(String phoneNumber, String password) {
        return null;
    }

    @Override
    public Observable<Boolean> requestPasswordReset(String phoneNumber) {
        return null;
    }

    @Override
    public Observable<Boolean> resetPassword(String smsCode, String password) {
        return null;
    }
}
