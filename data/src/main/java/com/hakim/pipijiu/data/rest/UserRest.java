package com.hakim.pipijiu.data.rest;

import com.hakim.pipijiu.data.entities.UserEntity;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/29 16:37 <br/>
 * Desc  :
 */
public interface UserRest {
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回用户实体
     */
    @POST("login")
    Call<UserEntity> login(@Query("username") String username, @Query("password") String password);

    @POST("users")
    Call<UserEntity> createUser(@Body RequestBody body);

    /**
     * 用户注册。使用手机号码+密码+验证码的形式
     *
     * @param body
     * @return 返回用户实体
     */
    @POST("usersByMobilePhone")
    Call<UserEntity> signUp(@Body RequestBody body);

    /**
     * 用户注册之验证手机号码
     *
     * @param smsCode 短信验证码
     * @return
     */
    @POST("verifyMobilePhone/{smsCode}")
    Call<ResponseBody> verifyMobilePhone(@Path("smsCode") String smsCode);

    /**
     * 请求短信验证码
     *
     * @param body
     * @return
     * @see #verifySmsCode(String)
     */
    @POST("requestSmsCode")
    Call<ResponseBody> requestSmsCode(@Body RequestBody body);

    /**
     * 验证短信验证码
     *
     * @param data data格式：6位数字验证码?mobilePhoneNumber=186xxxxxxxx
     * @return
     * @see #requestSmsCode(RequestBody)
     */
    @POST("verifySmsCode/{data}")
    Call<ResponseBody> verifySmsCode(@Path("data") String data);

    /**
     * 再次请求验证
     *
     * @param phoneNumber 手机号码
     * @return
     */
    @POST("requestMobilePhoneVerify")
    Call<ResponseBody> requestSmsCodeAgain(@Query("mobilePhoneNumber") String phoneNumber);

    /**
     * 重置密码之获取验证码
     *
     * @param phoneNumber 手机号码
     * @return 返回OKHttp响应数据
     */
    @POST("resetPasswordBySmsCode")
    Call<ResponseBody> requestSmsCodeToResetPassword(@Query("mobilePhoneNumber") String phoneNumber);

    /**
     * 重置密码之验证验证码
     *
     * @param smsCode     6位短信验证码
     * @param newPassword 新密码
     * @return
     */
    @PUT("resetPasswordBySmsCode/{smsCode}")
    Call<ResponseBody> resetPassword(@Path("smsCode") String smsCode, @Query("password") String newPassword);

    /**
     * 更新用户信息
     *
     * @param objectId 用户objectId
     * @param body
     * @return 返回OKHttp响应数据
     */
    @PUT("users/{objectId}")
    Call<ResponseBody> updateUser(@Header("X-LC-Session") String token, @Path("objectId") String objectId, @Body RequestBody body);
}
