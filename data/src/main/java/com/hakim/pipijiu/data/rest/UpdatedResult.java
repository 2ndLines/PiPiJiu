package com.hakim.pipijiu.data.rest;

import com.google.gson.annotations.SerializedName;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/3 11:22 <br/>
 * Desc  :
 */
public class UpdatedResult {
    @SerializedName("sessionToken")
    private String token;

    @SerializedName("objectId")
    private String uid;

    private String createdAt;

    public String getToken() {
        return token;
    }

    public String getUid() {
        return uid;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
