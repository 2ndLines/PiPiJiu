package com.hakim.pipijiu.model.data;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.reflect.Type;
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
    Observable<Long> insert(@NonNull T data);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    Observable<Integer> bulkInsert(@NonNull List<T> list);

    /**
     * 删除单条数据
     *
     * @param objectId 对象Id
     * @return
     */
    Observable<Integer> delete(@NonNull String objectId);

    /**
     * 批量删除
     *
     * @param where
     * @return
     */
    Observable<Integer> bulkDelete(@Nullable ContentValues where);

    /**
     * 更新数据
     *
     * @param where
     * @param newValues
     * @return 更新成功与否
     */
    Observable<Integer> update(@NonNull ContentValues where, @NonNull ContentValues newValues);


    /**
     * 获取详情
     *
     * @param objectId 对象Id
     * @return 对象实体
     */
    Observable<T> detail(@NonNull String objectId, Type typeOfT);

    /**
     * 查询数据
     *
     * @param where 查询条件
     * @return
     */
    Observable<List<T>> list(@NonNull ContentValues where, int skip, int limit, Type typeOfList);
}
