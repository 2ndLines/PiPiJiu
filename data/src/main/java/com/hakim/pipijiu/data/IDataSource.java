package com.hakim.pipijiu.data;

import android.support.annotation.NonNull;
import android.util.ArrayMap;

import java.util.List;

import rx.Observable;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/19 17:28 <br/>
 * Desc  : 数据操作接口
 *
 * @param <T> 实体类型
 */
public interface IDataSource<T> {

    /**
     * 插入单条数据
     *
     * @param data 实体对象
     * @return 返回对象的ObjectId
     */
    Observable<String> insert(@NonNull T data);

    /**
     * 删除单条数据
     *
     * @param objectId 对象Id
     */
    void delete(@NonNull String objectId);

    /**
     * 更新数据
     *
     * @param fields 待更新列表
     * @return 更新成功与否
     */
    <K, V> Observable<Boolean> update(@NonNull ArrayMap<K, V> fields);


    /**
     * 获取详情
     *
     * @param objectId 对象Id
     * @return 对象实体
     */
    Observable<T> detail(@NonNull String objectId);

    /**
     * 查询数据
     *
     * @param where 查询条件
     * @return
     */
    Observable<List<T>> list(@NonNull String where);
}
