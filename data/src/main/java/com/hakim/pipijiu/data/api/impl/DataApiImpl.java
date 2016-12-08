package com.hakim.pipijiu.data.api.impl;


import com.hakim.pipijiu.data.api.DataApi;

import java.util.List;

import rx.Observable;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2016/12/7 <br/>
 * Desc  :
 */
public class DataApiImpl<T> implements DataApi<T> {


    @Override
    public Observable<Boolean> insert(T t) {
        return null;
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
