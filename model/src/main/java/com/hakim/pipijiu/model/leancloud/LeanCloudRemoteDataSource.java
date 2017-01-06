package com.hakim.pipijiu.model.leancloud;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hakim.pipijiu.model.data.IDataSource;
import com.hakim.pipijiu.model.data.remote.RemoteDataImpl;
import com.hakim.pipijiu.model.retrofit.HttpClient;

import java.util.List;

import rx.Observable;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2017/1/6 <br/>
 * Desc  :
 */
public class LeanCloudRemoteDataSource<T> implements IDataSource<T> {
    private final DataService dataService;
    private final RemoteDataImpl dataImpl;

    public LeanCloudRemoteDataSource(RemoteDataImpl impl) {
        dataService = HttpClient.getInstance().createService(DataService.class);
        this.dataImpl = impl;
    }

    @Override
    public Observable<Long> insert(@NonNull T data) {
        return null;
    }

    @Override
    public Observable<Integer> bulkInsert(@NonNull List<T> list) {
        return null;
    }

    @Override
    public Observable<Integer> delete(@NonNull String objectId) {
        return null;
    }

    @Override
    public Observable<Integer> bulkDelete(@Nullable ContentValues where) {
        return null;
    }

    @Override
    public Observable<Integer> update(@NonNull ContentValues where, @NonNull ContentValues newValues) {
        return null;
    }

    @Override
    public Observable<T> detail(@NonNull String objectId) {
        return null;
    }

    @Override
    public Observable<List<T>> list(@NonNull ContentValues where, int skip, int limit) {
        return null;
    }
}
