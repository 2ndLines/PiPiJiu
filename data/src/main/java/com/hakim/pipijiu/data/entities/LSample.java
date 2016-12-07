package com.hakim.pipijiu.data.entities;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/7 15:10 <br/>
 * Desc  : 皮具样品
 */
public class LSample {
    private String id;
    /**
     * 品牌Id
     */
    private String brandId;

    /**
     * 品牌名称
     */
    private String brand;

    /**
     * 功能：皮衣、皮鞋、皮包等
     */
    private String function;

    /**
     * 皮具型号
     */
    private String model;

    /**
     * 人群:男士、女士
     */
    private String crowd;

    /**
     * 面料材质：真皮、人造革等
     */
    private String texture;

    /**
     * 样图
     */
    private String[] images;

}
