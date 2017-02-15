package com.hakim.pipijiu.model.leancloud;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hakim.pipijiu.model.data.IDataSource;

import java.lang.reflect.Type;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2017/1/6 <br/>
 * Desc  :
 */
public class LeanCloudRemoteDataSource<T> implements IDataSource<T> {
    private final DataService dataService;
    private final RetrofitClient client;
    private final String className;

    public LeanCloudRemoteDataSource(String className) {
        this.dataService = HttpClient.getInstance().createService(DataService.class);
        this.className = className;
        client = RetrofitClient.getInstance();
    }

    @Override
    public Observable<Long> insert(@NonNull T data) {
        return client.doRequest(dataService.insert(className, data)).map(new Func1<ServiceResult, Long>() {
            @Override
            public Long call(ServiceResult serviceResult) {
                return (long) (serviceResult.getLid() != null ? 0 : -1);
            }
        });
    }

    @Override
    public Observable<Integer> bulkInsert(@NonNull List<T> list) {
        return null;
    }

    @Override
    public Observable<Integer> delete(@NonNull String objectId) {
        return client.doRequest(dataService.delete(className, objectId)).map(new Func1<ServiceResult, Integer>() {
            @Override
            public Integer call(ServiceResult serviceResult) {
                return serviceResult != null ? 1 : 0;
            }
        });
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
        return client.request(dataService.detail(className, objectId), typeOfT).map(new Func1<Object, T>() {
            @Override
            public T call(Object o) {
                return (T) o;
            }
        });
    }

    @Override
    public Observable<List<T>> list(@NonNull ContentValues where, int skip, int limit, Type typeOfList) {
        return null;
    }
}
