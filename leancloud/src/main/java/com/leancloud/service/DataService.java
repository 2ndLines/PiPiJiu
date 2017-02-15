package com.leancloud.service;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/3 11:22 <br/>
 * Desc  : 数据rest api
 */
public interface DataService {
    String PARAMETERS_CLASS = "classes/{className}";
    String PARAMETERS_OBJECT = "classes/{className}/{objectId}";

    /**
     * 插入对象
     *
     * @param className 表名
     * @param t         对象类型
     * @return
     */
    @POST(PARAMETERS_CLASS)
    Call<ServiceResult> insert(@Path("className") String className, @Body Object t);

    /**
     * 获取对象详情
     *
     * @param className 表名
     * @param objectId  对象id
     * @return
     */
    @GET(PARAMETERS_OBJECT)
    Call<ResponseBody> detail(@Path("className") String className, @Path("objectId") String objectId);

    /**
     * 获取对象列表
     *
     * @param className 表名
     * @param where     查询条件
     * @param skip      跳过的条数
     * @param limit     返回对象的最大条数
     * @return
     */
    @GET(PARAMETERS_CLASS)
    <T> Call<List<Object>> list(@Path("className") String className, @Query("where") String where, @Query("skip") int skip, @Query("limit") int limit);

    /**
     * 更新对象
     *
     * @param className 表名
     * @param objectId  对象id
     * @param body      待更新的内容
     * @return
     */
    @PUT(PARAMETERS_OBJECT)
    Call<ServiceResult> update(@Path("className") String className, @Path("objectId") String objectId, @Body Object body);

    /**
     * 删除对象
     *
     * @param className 表名
     * @param objectId  对象id
     * @return
     */
    @DELETE(PARAMETERS_OBJECT)
    Call<ServiceResult> delete(@Path("className") String className, @Path("objectId") String objectId);

    /**
     * 删除表中符合条件的所有对象
     *
     * @param className 表名
     * @param where     查询条件
     * @return
     */
    @DELETE(PARAMETERS_CLASS)
    Call<ServiceResult> deleteBulk(@Path("className") String className, @Query("where") String where);

}
