package com.leancloud.service;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/3 17:41 <br/>
 * Desc  : 文件上传及删除操作
 */
public interface FileUploadService {

    /**
     * RequestBody building example:
     * <pre><code>
     * File file = new File();
     * RequestBody.create(MediaType.parse("image/*"), file)
     * </code></pre>
     *
     * @param fileName 文件名
     * @param body     RequestBody对象
     * @return
     */
    @Headers("Content-Type: image/png")
    @POST("files/{fileName}")
    Call<LeanCloudFile> upload(@Path("fileName") String fileName, @Body RequestBody body);

    @DELETE("files/{objectId}")
    Call<ResponseBody> delete(@Path("objectId") String objectId);
}
