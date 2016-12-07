package com.hakim.pipijiu.data.rest;

import java.util.List;

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
 * Desc  :
 */
public interface ObjectRest<T> {
    String PARAMETERS_CLASS = "classes/{className}";
    String PARAMETERS_OBJECT = "classes/{className}/{objectId}";

    @POST(PARAMETERS_CLASS)
    Call<UpdatedResult> insert(@Path("className") String className, @Body T t);

    @GET(PARAMETERS_OBJECT)
    Call<T> objectDetail(@Path("className") String className, @Path("objectId") String objectId);

    @GET(PARAMETERS_CLASS)
    Call<List<T>> objectList(@Path("className") String className, @Query("where") String where, @Query("skip") int skip, @Query("limit") int limit);

    @PUT(PARAMETERS_OBJECT)
    Call<UpdatedResult> update(@Path("className") String className, @Path("objectId") String objectId, @Body T body);

    @DELETE(PARAMETERS_OBJECT)
    Call<UpdatedResult> delete(@Path("className") String className, @Path("objectId") String objectId);

    @DELETE(PARAMETERS_CLASS)
    Call<UpdatedResult> deleteAll(@Path("className") String className, @Query("where") String where);

}
