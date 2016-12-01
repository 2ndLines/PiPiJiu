package com.hakim.pipijiu.data.rest;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/30 14:30 <br/>
 * Desc  :
 */
public enum ApiFactory {
    INSTANCE;
    private final UserRest userRest;

    ApiFactory() {
        userRest = RetrofitClient.INSTANCE.getRetrofit().create(UserRest.class);
    }

    public UserRest getUserRest() {
        return userRest;
    }

}
