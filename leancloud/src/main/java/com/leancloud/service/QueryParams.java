package com.leancloud.service;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/3 15:00 <br/>
 * Desc  :
 */
public class QueryParams {
    /**
     * 查询条件
     */
    private String where;
    /**
     * 数据位置游标
     */
    private String cursor;
    /**
     * 跳过的条目数
     */
    private int skip;
    /**
     * 本次查询的最大返回数
     */
    private int limit;
    /**
     * 排序字段
     */
    private int scan_key;
}
