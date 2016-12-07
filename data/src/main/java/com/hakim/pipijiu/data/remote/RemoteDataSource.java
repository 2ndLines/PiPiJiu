package com.hakim.pipijiu.data.remote;

import android.support.annotation.NonNull;
import android.util.ArrayMap;

import com.hakim.pipijiu.data.IDataSource;
import com.hakim.pipijiu.data.api.DataApi;
import com.hakim.pipijiu.data.api.DataApiImpl;

import java.util.List;

import rx.Observable;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2016/12/7 <br/>
 * Desc  :
 */
public class RemoteDataSource<T> implements IDataSource<T> {

    private final DataApi<T> api;
    public RemoteDataSource(@NonNull String className){
        api = new DataApiImpl<>(className);
    }

    @Override
    public Observable<String> insert(@NonNull T data) {
        return null;
    }

    @Override
    public void delete(@NonNull String objectId) {

    }

    @Override
    public <K, V> Observable<Boolean> update(@NonNull ArrayMap<K, V> fields) {
        return null;
    }

    @Override
    public Observable<T> detail(@NonNull String objectId) {
        return null;
    }

    @Override
    public Observable<List<T>> list(@NonNull String where) {
        return null;
    }
}
