package com.leancloud.service;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/8 10:58 <br/>
 * Desc  :
 */
public class ServiceConfig {
    String CLASS_NAME_USERS = "users";
    String CLASS_NAME_FILES = "files";
    String CLASS_NAME_NORMAL = "classes/?";

    /**
     * 通过username或者mobilePhoneNumber登录
     */
    String ACTION_LOGIN = "login";
    /**
     * 请求验证码
     */
    String ACTION_REQUEST_SMS_CODE = "requestSmsCode";
    /**
     * 验证验证码
     */
    String ACTION_VERIFY_SMS_CODE = "verifySmsCode";
    /**
     * 使用手机号码注册
     */
    String ACTION_SIGNIN_BY_PHONE = "usersByMobilePhone";
    /**
     * 请求验证码以验证手机号码
     */
    String ACTION_REQUEST_MOBILE_PHONE_VERIFY = "requestMobilePhoneVerify";
    /**
     * 验证手机号码
     */
    String ACTION_VERIFY_MOBILE_PHONE = "verifyMobilePhone";
    /**
     * 请求验证码以登录
     */
    String ACTION_REQUEST_LOGIN_BY_SMS_CODE = "requestLoginSmsCode";

    /**
     * 请求验证码以重置密码
     */
    String ACTION_REQUEST_PASSWORD_RESET_BY_SMS_CODE = "requestPasswordResetBySmsCode";
    /**
     * 通过验证码重置密码
     */
    String ACTION_RESET_PASSWORD_BY_SMS_CODE = "resetPasswordBySmsCode";
}
