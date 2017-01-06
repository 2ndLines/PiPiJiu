package com.hakim.pipijiu.model.data.local;

import android.content.ContentValues;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2017/1/5 <br/>
 * Desc  :
 */
public abstract class LocalDataImpl<T> {
    abstract String tableName();

    abstract ContentValues asContentValue(T t);
}
