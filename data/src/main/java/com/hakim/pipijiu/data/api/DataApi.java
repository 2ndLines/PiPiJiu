package com.hakim.pipijiu.data.api;


import java.util.List;

import rx.Observable;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2016/12/7 <br/>
 * Desc  :
 */
public interface DataApi<T> {
    Observable<Boolean> insert(T t);

    Observable<T> detail(String dataId);

    Observable<List<T>> list(String where, int skip, int limit);

    Observable<Boolean> update(String dataId, T updates);

    Observable<Boolean> delete(String dataId);

    Observable<Boolean> deleteBulk(String where);
}
