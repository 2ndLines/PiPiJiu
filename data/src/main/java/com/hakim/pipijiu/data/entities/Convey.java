package com.hakim.pipijiu.data.entities;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/7 17:18 <br/>
 * Desc  : 运送方式
 */
public class Convey {
    /**
     * 自提方式
     */
    public static final int CONVEY_WAY_SELF = 0;
    /**
     * 快递方式
     */
    public static final int CONVEY_WAY_EXPRESS = 1;

    /**
     * 送件方式
     */
    private String out;

    /**
     * 取件方式
     */
    private String back;


    /**
     * 物流编号
     */
    private String no;


    /**
     * 物流跟踪
     */
    private String trace[];

}
