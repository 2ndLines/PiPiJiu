package com.hakim.pipijiu.model.data.local;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hakim.pipijiu.model.data.IDataSource;
import com.squareup.sqlbrite.BriteDatabase;

import java.util.List;
import java.util.concurrent.Callable;

import rx.Observable;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2016/12/7 <br/>
 * Desc  :
 */
public class LocalDataSource<T> implements IDataSource<T> {
    private final BriteDatabase database;
    private final LocalDataImpl<T> dataImpl;
    private final String tableName;

    public LocalDataSource(@NonNull BriteDatabase database, @NonNull LocalDataImpl<T> dataImpl) {
        this.database = database;
        this.dataImpl = dataImpl;
        this.tableName = dataImpl.tableName();
    }

    @Override
    public Observable<Long> insert(@NonNull final T data) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return database.insert(tableName, dataImpl.asContentValue(data));
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
    public Observable<Integer> update(@NonNull final ContentValues where, @NonNull final ContentValues newValues) {

        return Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                StringBuilder whereBuilder = new StringBuilder();
                String[] whereArgs = new String[where.size()];
                whereValues2WhereClause(where, whereBuilder, whereArgs);
                return database.update(tableName, newValues, whereBuilder.toString(), whereArgs);
            }
        });
    }

    @Override
    public Observable<T> detail(@NonNull String objectId) {
        return null;
    }

    @Override
    public Observable<List<T>> list(@NonNull ContentValues where, int skip, int limit) {
        return null;
    }

    private static void whereValues2WhereClause(ContentValues where, StringBuilder whereClause, String[] whereArgs) {

    }

}
