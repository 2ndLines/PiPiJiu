package com.hakim.pipijiu.model.data.remote;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hakim.pipijiu.model.data.IDataSource;

import java.lang.reflect.Type;
import java.util.List;

import rx.Observable;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2016/12/7 <br/>
 * Desc  :
 */
public class RemoteDataSource<T> implements IDataSource<T> {
    private final IDataSource<T> dataSource;
    public RemoteDataSource(IDataSource<T> dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Observable<Long> insert(@NonNull T data) {
        return dataSource.insert(data);
    }

    @Override
    public Observable<Integer> bulkInsert(@NonNull List<T> list) {
        return dataSource.bulkInsert(list);
    }

    @Override
    public Observable<Integer> delete(@NonNull String objectId) {
        return dataSource.delete(objectId);
    }

    @Override
    public Observable<Integer> bulkDelete(@Nullable ContentValues where) {
        return dataSource.bulkDelete(where);
    }

    @Override
    public Observable<Integer> update(@NonNull ContentValues where, @NonNull ContentValues newValues) {
        return dataSource.update(where, newValues);
    }

    @Override
    public Observable<T> detail(@NonNull String objectId, Type typeOfT) {
        return dataSource.detail(objectId,typeOfT);
    }

    @Override
    public Observable<List<T>> list(@NonNull ContentValues where, int skip, int limit, Type typeOfList) {
        return dataSource.list(where, skip, limit, typeOfList);
    }
}
