package com.hakim.pipijiu.data.repository;

import android.support.annotation.NonNull;
import android.util.ArrayMap;

import com.hakim.pipijiu.data.IOrderSource;
import com.hakim.pipijiu.data.entities.Order;

import java.util.List;

import rx.Observable;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/7 18:55 <br/>
 * Desc  :
 */
public class OrderRepository implements IOrderSource {

    @Override
    public Observable<Boolean> cancelOrder(String orderId) {
        return null;
    }

    @Override
    public Observable<Boolean> undoOrder(String orderId) {
        return null;
    }

    @Override
    public Observable<Boolean> completeOrder(String orderId) {
        return null;
    }

    @Override
    public Observable<String> insert(@NonNull Order data) {
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
    public Observable<Order> detail(@NonNull String objectId) {
        return null;
    }

    @Override
    public Observable<List<Order>> list(@NonNull String where) {
        return null;
    }
}
