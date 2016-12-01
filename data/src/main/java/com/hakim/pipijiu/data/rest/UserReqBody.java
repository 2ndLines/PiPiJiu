package com.hakim.pipijiu.data.rest;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/30 16:18 <br/>
 * Desc  :
 */

@AutoValue
public abstract class UserReqBody {

    @Nullable
    public abstract String mobilePhoneNumber();

    @Nullable
    public abstract String ttl();

    @Nullable
    public abstract String username();

    @Nullable
    public abstract String password();

    @Nullable
    public abstract String smsCode();

    @Nullable
    public abstract String op();

    public static Builder newBuilder() {
        return new AutoValue_UserReqBody.Builder();
    }

    @AutoValue.Builder
    public interface Builder {
        Builder mobilePhoneNumber(String phone);

        Builder ttl(String ttl);

        Builder password(String pwd);

        Builder smsCode(String code);

        Builder op(String op);

        Builder username(String username);

        UserReqBody build();
    }

}
