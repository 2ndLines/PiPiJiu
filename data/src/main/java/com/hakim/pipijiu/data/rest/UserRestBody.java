package com.hakim.pipijiu.data.rest;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/3 15:59 <br/>
 * Desc  :
 */
public class UserRestBody {
    private String username;
    private String password;
    private String mobilePhoneNumber;
    private String op;
    private String smsCode;
    private String ttl;

    private UserRestBody(){
        //Empty constructor
    }

    private UserRestBody(Builder builder) {
        username = builder.username;
        password = builder.password;
        mobilePhoneNumber = builder.mobilePhoneNumber;
        op = builder.op;
        smsCode = builder.smsCode;
        ttl = builder.ttl;
    }

    public static Builder newBuilder(){
        return new UserRestBody.Builder();
    }

    public static final class Builder {
        private String username;
        private String password;
        private String mobilePhoneNumber;
        private String op;
        private String smsCode;
        private String ttl;

        private Builder() {
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

        public UserRestBody build() {
            return new UserRestBody(this);
        }
    }
}
