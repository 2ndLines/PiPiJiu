package com.hakim.pipijiu.model.manager;

import com.hakim.pipijiu.model.entities.User;

import rx.Observable;


/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/19 17:35 <br/>
 * Desc  :
 */
public interface UserManager {
    /**
     * 登录
     *
     * @param phoneNumber 手机号码
     * @param password    密码
     * @return
     */
    Observable<User> login(String phoneNumber, String password);

    /**
     * 注册
     *
     * @param phoneNumber 手机号码
     * @param password    密码
     * @return
     */
    Observable<Boolean> signUp(String phoneNumber, String smsCode, String password);

    /**
     * 获取用户信息
     *
     * @param uid 用户id
     * @return
     */
    Observable<User> getUser(String uid);

    Observable<User> fetchMe();

    Observable<User> refreshToken();

    /**
     * 请求验证码
     *
     * @param phoneNumber
     * @param opType
     * @return
     */
    Observable<Boolean> requestSmsCode(String phoneNumber, String opType);

    /**
     * 验证验证码
     *
     * @param phoneNumber
     * @param smsCode
     * @return
     */
    Observable<Boolean> verifySmsCode(String phoneNumber, String smsCode);

    /**
     * 请求用于重置密码的验证码
     *
     * @return
     */
    Observable<Boolean> requestSmsCodeToResetPassword(String phoneNumber);

    /**
     * 重置密码
     *
     * @param smsCode     验证码
     * @param newPassword 新密码
     * @return
     */
    Observable<Boolean> resetPassword(String smsCode, String newPassword);

    /**
     * 更新用户信息
     *
     * @param entity
     * @return
     */
    Observable<User> updateUser(User entity);

}
