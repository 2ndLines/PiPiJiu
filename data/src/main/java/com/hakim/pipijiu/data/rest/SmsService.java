package com.hakim.pipijiu.data.rest;

import com.hakim.pipijiu.data.entities.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2016/12/7 <br/>
 * Desc  : 短信RestApi
 */
public interface SmsService {
    /**
     * 请求短信验证码
     *
     * @param body mobilePhoneNumber&op的body
     * @return
     */
    @POST("requestSmsCode")
    Call<ResponseBody> requestSmsCode(@Body ServiceBody body);

    /**
     * 验证短信验证码
     *
     * @param phoneNumber
     * @param smsCode
     * @return
     */
    @POST("verifySmsCode/{smsCode}")
    Call<ResponseBody> verifySmsCode(@Query("mobilePhoneNumber") String phoneNumber, @Path("smsCode") String smsCode);

    /**
     * 使用手机号码注册用户
     *
     * @param body mobilePhoneNumber&smsCode&password的body
     * @return
     */
    @POST("usersByMobilePhone")
    Call<User> signInByMobilePhone(@Body ServiceBody body);

    /**
     * 使用手机号码和密码登录
     *
     * @param phoneNumber 手机号码
     * @param password    登录密码
     * @return
     */
    @GET("login")
    Call<User> loginByMobilePhone(@Query(value = "mobilePhoneNumber", encoded = true) String phoneNumber, @Query(value = "password", encoded = true) String password);

    /**
     * 请求短信验证码以重置密码
     *
     * @param body mobilePhoneNumber的body
     * @return
     */
    @POST("requestPasswordResetBySmsCode")
    Call<ResponseBody> requestPasswordResetBySmsCode(@Body ServiceBody body);

    /**
     * 验证短信验证码以重置密码
     *
     * @param smsCode 短信验证码
     * @param body    password的body
     * @return
     */
    @PUT("resetPasswordBySmsCode/{smsCode}")
    Call<ResponseBody> resetPasswordBySmsCode(@Path("smsCode") String smsCode, @Body ServiceBody body);
}
