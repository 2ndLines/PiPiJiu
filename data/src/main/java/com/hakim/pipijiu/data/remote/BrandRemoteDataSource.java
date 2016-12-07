package com.hakim.pipijiu.data.remote;

import android.support.annotation.NonNull;
import android.util.ArrayMap;

import com.hakim.pipijiu.data.IDataSource;
import com.hakim.pipijiu.data.entities.Brand;

import java.util.List;

import rx.Observable;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/7 14:58 <br/>
 * Desc  :
 */
public class BrandRemoteDataSource implements IDataSource<Brand> {

    @Override
    public Observable<String> insert(@NonNull Brand data) {
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
    public Observable<Brand> detail(@NonNull String objectId) {
        return null;
    }

    @Override
    public Observable<List<Brand>> list(@NonNull String where) {
        return null;
    }
}
