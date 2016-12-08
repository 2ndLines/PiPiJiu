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
    /**
     * 插入数据
     *
     * @param t
     * @return
     */
    Observable<Boolean> insert(T t);

    /**
     * 获取对象
     *
     * @param dataId
     * @return
     */
    Observable<T> detail(String dataId);

    /**
     * 获取列表
     *
     * @param where
     * @param skip
     * @param limit
     * @return
     */
    Observable<List<T>> list(String where, int skip, int limit);

    /**
     * 更新对象
     *
     * @param dataId
     * @param updates
     * @return
     */
    Observable<Boolean> update(String dataId, T updates);

    /**
     * 删除对象
     *
     * @param dataId
     * @return
     */
    Observable<Boolean> delete(String dataId);

    /**
     * 批量删除
     *
     * @param where
     * @return
     */
    Observable<Boolean> deleteBulk(String where);
}
