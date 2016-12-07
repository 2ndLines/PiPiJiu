package com.hakim.pipijiu.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/29 15:20 <br/>
 * Desc  : 用户
 */
public class User {
    @SerializedName("objectId")
    private String uid;
    @SerializedName("sessionToken")
    private String token;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号码
     */
    @SerializedName("mobilePhone")
    private String phone;
    /**
     * 注册时间
     */
    private String createdAt;

    /**
     * 性别
     */
    private String sex;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 评分
     */
    private int score;

    public String getUid() {
        return uid;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public String getCreatedAt() {
        return createdAt;
    }

}
