package com.leancloud.service;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/3 15:59 <br/>
 * Desc  : 网络服务请求体
 */
public class ServiceBody {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String mobilePhoneNumber;
    /**
     * 操作类型，如注册，
     */
    private String op;
    /**
     * 验证码
     */
    private String smsCode;
    /**
     * 验证码有效时间
     */
    private String ttl;

    private ServiceBody() {
        //Empty constructor
    }

    private ServiceBody(Builder builder) {
        username = builder.username;
        password = builder.password;
        mobilePhoneNumber = builder.mobilePhoneNumber;
        op = builder.op;
        smsCode = builder.smsCode;
        ttl = builder.ttl;
    }

    public static Builder newBuilder() {
        return new ServiceBody.Builder();
    }

    public static final class Builder {
        private String username;
        private String password;
        private String mobilePhoneNumber;
        private String op;
        private String smsCode;
        private String ttl;

        public Builder() {
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder mobilePhoneNumber(String val) {
            mobilePhoneNumber = val;
            return this;
        }

        public Builder op(String val) {
            op = val;
            return this;
        }

        public Builder smsCode(String val) {
            smsCode = val;
            return this;
        }

        public Builder ttl(String val) {
            ttl = val;
            return this;
        }

        public ServiceBody build() {
            return new ServiceBody(this);
        }
    }
}
