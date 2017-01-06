package com.hakim.pipijiu.model.data.local;

import android.content.ContentValues;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2017/1/5 <br/>
 * Desc  :
 */
public abstract class LocalDataImpl<T> {

    /**
     * 数据库名称
     */
    public abstract String tableName();

    /**
     * 将实体{@code t}转化为ContentValues对象
     *
     * @param t
     * @return
     */
    public abstract ContentValues asContentValue(T t);
}
