package com.hakim.pipijiu.model.data;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.reflect.Type;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2016/12/7 <br/>
 * Desc  :
 */
public class DataRepository<T> implements IDataSource<T> {
    private final IDataSource<T> localDataSource;
    private final IDataSource<T> remoteDataSource;

    public DataRepository(IDataSource<T> localDataSource, IDataSource<T> remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<Long> insert(@NonNull final T data) {
        return remoteDataSource.insert(data).flatMap(new Func1<Long, Observable<Long>>() {
            @Override
            public Observable<Long> call(Long id) {
                if (id == 0) {//创建成功
                    //插入本地数据库
                    return localDataSource.insert(data);
                } else {//创建失败
                    return Observable.just((long) -1);
                }
            }
        });
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
    public Observable<T> detail(@NonNull String objectId, Type typeOfT) {
        return null;
    }

    @Override
    public Observable<List<T>> list(@NonNull ContentValues where, int skip, int limit, Type typeOfList) {
        return null;
    }
}
