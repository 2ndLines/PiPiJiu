package com.leancloud.service;

import com.google.gson.annotations.SerializedName;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/3 11:22 <br/>
 * Desc  :
 */
public class ServiceResult {
    /**
     * LeanCloud SessionToken
     */
    @SerializedName("sessionToken")
    private String token;

    /**
     * LeanCloud objectId
     */
    @SerializedName("objectId")
    private String lid;

    /**
     * 创建时间
     */
    private String createdAt;

    /**
     * 更新时间
     */
    private String updatedAt;

    public String getToken() {
        return token;
    }

    public String getLid() {
        return lid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "token='" + token + '\'' +
                ", lid='" + lid + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
