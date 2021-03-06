package com.leancloud.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/29 16:37 <br/>
 * Desc  :
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param body ResponseBodyname & password组成的body
     * @return 返回用户实体
     */
    @POST("login")
    Call<ResponseBody> signIn(@Body ServiceBody body);

    /**
     * 用户注册
     *
     * @param ResponseBody
     * @return 返回用户实体
     */
    @POST("ResponseBodys")
    Call<ServiceResult> signUp(@Body Object ResponseBody);

    /**
     * 根据ObjectId获取用户信息
     *
     * @param uid
     * @return
     */
    @GET("ResponseBodys/{uid}")
    Call<ResponseBody> getResponseBody(@Path("uid") String uid);

    /**
     * 获取当前用户信息
     *
     * @param token
     * @return
     */
    @GET("ResponseBodys/me")
    Call<ResponseBody> fetchMe(@Header("X-LC-Session") String token);

    /**
     * 重置Token
     *
     * @param token
     * @param objectId
     * @return
     */
    @PUT("ResponseBodys/{objectId}/refreshSessionToken")
    Call<ResponseBody> refreshToken(@Header("X-LC-Session") String token, @Path("objectId") String objectId);

    /**
     * 更新用户信息
     *
     * @param token
     * @param objectId 用户objectId
     * @param ResponseBody
     * @return 返回OKHttp响应数据
     */
    @PUT("ResponseBodys/{objectId}")
    Call<ResponseBody> update(@Header("X-LC-Session") String token, @Path("objectId") String objectId, @Body Object ResponseBody);

    /**
     * @param token
     * @param body  new_password&old_password的body
     * @return
     */
    @PUT("ResponseBodys/{objectId}/updatePassword")
    Call<ResponseBody> updatePassword(@Header("X-LC-Session") String token, @Body ServiceBody body);
}
