package com.hakim.pipijiu.data.api.impl;

import com.hakim.pipijiu.data.api.SmsApi;
import com.hakim.pipijiu.data.entities.User;
import com.hakim.pipijiu.data.rest.ServiceBody;
import com.hakim.pipijiu.data.rest.SmsService;
import com.hakim.pipijiu.data.retrofit.HttpClient;
import com.hakim.pipijiu.data.retrofit.RetrofitClient;

import rx.Observable;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/8 15:02 <br/>
 * Desc  :
 */
public class SmsApiImpl extends RetrofitClient implements SmsApi {
    private final SmsService service;

    public SmsApiImpl() {
        service = HttpClient.getInstance().createService(SmsService.class);
    }

    @Override
    public Observable<Boolean> requestSmsCode(String phoneNumber) {
        ServiceBody body = new ServiceBody.Builder()
                .mobilePhoneNumber(phoneNumber)
                .build();
        return doRequestForBoolean(service.requestSmsCode(body));
    }

    @Override
    public Observable<Boolean> verifySmsCode(String phoneNumber, String smsCode) {
        return doRequestForBoolean(service.verifySmsCode(phoneNumber, smsCode));
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
