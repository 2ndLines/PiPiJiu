package com.hakim.pipijiu.data.entities;

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
    private String objectId;

    private String sessionToken;
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

    public String getObjectId() {
        return objectId;
    }

    public String getSessionToken() {
        return sessionToken;
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
                "objectId='" + objectId + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
