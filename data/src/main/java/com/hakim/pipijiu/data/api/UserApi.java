package com.hakim.pipijiu.data.api;

import com.hakim.pipijiu.data.entities.UserEntity;

import java.util.Map;

import rx.Observable;


/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/19 17:35 <br/>
 * Desc  :
 */
public interface UserApi {
    /**
     * 登录
     *
     * @param phoneNumber 手机号码
     * @param password    密码
     * @return
     */
    Observable<UserEntity> login(String phoneNumber, String password);

    /**
     * 注册
     *
     * @param phoneNumber 手机号码
     * @param password    密码
     * @return
     */
    Observable<UserEntity> signUp(String phoneNumber, String smsCode, String password);

    /**
     * @param phoneNumber
     * @param opType
     * @return
     */
    Observable<Boolean> requestSmsCode(String phoneNumber, String opType);

    Observable<Boolean> verifySmsCode(String phoneNumber, String smsCode);

    /**
     * @return
     */
    Observable<Boolean> requestSmsCodeToResetPassword();

    /**
     * @param smsCode     验证码
     * @param newPassword 新密码
     * @return
     */
    Observable<Boolean> resetPassword(String smsCode, String newPassword);

    /**
     * 更新用户信息
     *
     * @param fieldMap 更新字段与值的map
     * @return
     */
    Observable<Boolean> updateUser(Map<String, String> fieldMap);

}
