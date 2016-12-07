package com.hakim.pipijiu.data.repository;

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
 * Date  : 2016/12/7 18:49 <br/>
 * Desc  :
 */
public class BrandRepository implements IDataSource<Brand> {
    @Override
    public Observable<String> insert(@NonNull Brand data) {
        throw new UnsupportedOperationException("Invalid");
    }

    @Override
    public void delete(@NonNull String objectId) {
        throw new UnsupportedOperationException("Invalid");
    }

    @Override
    public <K, V> Observable<Boolean> update(@NonNull ArrayMap<K, V> fields) {
        throw new UnsupportedOperationException("Invalid");
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
