package com.hakim.pipijiu.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/29 15:20 <br/>
 * Desc  : 用户实体
 */
public class UserEntity {
    /**
     * LeanCloud objectId
     */
    @SerializedName("objectId")
    private String uid;

    @SerializedName("sessionToken")
    private String token;
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 注册时间
     */
    private String createdAt;

    public String getUid() {
        return uid;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid='" + uid + '\'' +
                ", token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
