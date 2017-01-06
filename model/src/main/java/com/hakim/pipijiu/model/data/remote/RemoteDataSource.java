package com.hakim.pipijiu.model.data.remote;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hakim.pipijiu.model.data.IDataSource;

import java.util.List;

import rx.Observable;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2016/12/7 <br/>
 * Desc  :
 */
public class RemoteDataSource<T> implements IDataSource<T> {
    private final IDataSource<T> remoteDataSource;
    public RemoteDataSource(IDataSource<T> dataSource){
        this.remoteDataSource = dataSource;
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
