package com.hakim.pipijiu.model.manager;

import com.hakim.pipijiu.model.entities.User;

import rx.Observable;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/8 11:18 <br/>
 * Desc  :
 */
public interface SMSManager {
    /**
     * 请求短信验证码
     *
     * @param phoneNumber
     * @return
     */
    Observable<Boolean> requestSmsCode(String phoneNumber);

    /**
     * 验证短信验证码
     *
     * @param phoneNumber
     * @param smsCode
     * @return
     */
    Observable<Boolean> verifySmsCode(String phoneNumber, String smsCode);

    /**
     * 使用手机号码注册账户，并发出短信验证码
     *
     * @param phoneNumber
     * @param smsCode
     * @param password
     * @return
     */
    Observable<User> signInByPhone(String phoneNumber, String smsCode, String password);

    /**
     * 请求手机号码验证，成功后会发出短信验证码
     *
     * @param phoneNumber
     * @return
     */
    Observable<Boolean> requestMobilePhoneVerify(String phoneNumber);

    /**
     * 验证手机号码
     *
     * @param smsCode
     * @return
     */
    Observable<Boolean> verifyMobilePhone(String smsCode);


    /**
     * 使用手机号码登录
     *
     * @param phoneNumber
     * @param password
     * @return
     */
    Observable<User> loginByMobilePhone(String phoneNumber, String password);

    /**
     * 请求短信验证码以重置密码
     *
     * @param phoneNumber
     * @return
     */
    Observable<Boolean> requestPasswordReset(String phoneNumber);

    /**
     * 重置密码
     *
     * @param smsCode
     * @param password
     * @return
     */
    Observable<Boolean> resetPassword(String smsCode, String password);

}
