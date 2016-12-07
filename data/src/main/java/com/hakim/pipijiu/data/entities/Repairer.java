package com.hakim.pipijiu.data.entities;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/7 18:03 <br/>
 * Desc  : 修护者
 */
public class Repairer extends User {

    /**
     * 店铺地址的纬度
     */
    private long latitude;

    /**
     * 店铺地址的经度
     */
    private long longitude;

    /**
     * 店铺地址
     */
    private String address;
}
