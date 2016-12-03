package com.hakim.pipijiu.data.api;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/2 19:38 <br/>
 * Desc  :
 */
public interface ObjectApi {
    /**
     * 插入数据
     *
     * @param data
     * @return 返回对象的ObjectId
     */
    <T> Observable<String> insert(T data);

    void delete(String objectId);

    Observable<Boolean> update(Map<String, ?> fields);

    <T> Observable<List<T>> find(String where);

}
