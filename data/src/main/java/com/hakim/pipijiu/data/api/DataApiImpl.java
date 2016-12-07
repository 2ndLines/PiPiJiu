package com.hakim.pipijiu.data.api;


import com.hakim.pipijiu.data.rest.DataRest;
import com.hakim.pipijiu.data.rest.UpdatedResult;
import com.hakim.pipijiu.data.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import rx.Observable;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2016/12/7 <br/>
 * Desc  :
 */
public class DataApiImpl<T> implements DataApi<T> {
    private final String className;
    private final DataRest rest;
    private RetrofitClient client;
    public DataApiImpl(String className){
        this.className = className;
        this.client = RetrofitClient.getInstance();
        this.rest = client.create(DataRest.class);
    }

    @Override
    public Observable<Boolean> insert(T t) {
        return client.doRequestForBoolean(rest.insert(className, t));
    }

    @Override
    public Observable<T> detail(String dataId) {
        return null;
    }

    @Override
    public Observable<List<T>> list(String where, int skip, int limit) {
        return null;
    }

    @Override
    public Observable<Boolean> update(String dataId, T updates) {
        return null;
    }

    @Override
    public Observable<Boolean> delete(String dataId) {
        return null;
    }

    @Override
    public Observable<Boolean> deleteBulk(String where) {
        return null;
    }
}
