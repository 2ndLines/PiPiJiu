package com.hakim.pipijiu.data.retrofit;

import okhttp3.RequestBody;
import retrofit2.Call;
import rx.Observable;
import rx.functions.Func1;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/2 9:45 <br/>
 * Desc  :
 */
public interface RetrofitApi {
    /**
     * 生成RequestBody对象
     *
     * @param t   请求的body
     * @param <T> body的类型
     * @return 返回Retrofit的RequestBody对象
     * @see RequestBody
     */
    <T> RequestBody buildBody(T t);

    /**
     * 执行Retrofit请求
     *
     * @param call   Call的实例
     * @param mapper 将T类型转换为R类型,如果mapper为空，则将T强制转换位R
     * @param <T>    call实例中的类型
     * @param <R>    返回的结果类型
     * @return
     */
    <T, R> Observable<R> doRequest(Call<T> call, Func1<T, R> mapper);
}
