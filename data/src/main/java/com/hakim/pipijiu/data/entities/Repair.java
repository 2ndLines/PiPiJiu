package com.hakim.pipijiu.data.entities;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/7 16:35 <br/>
 * Desc  : 修护实体
 */
public class Repair {
    /**
     * 维修编号
     */
    private String no;
    /**
     * 开始时间,格式：yyyyMMdd HH:mm:dd
     */
    private String startedAt;
    /**
     * 预计完成时间，格式：yyyyMMdd HH:mm:dd
     */
    private String estimatedAt;

    /**
     * 完成时间,格式：yyyyMMdd HH:mm:dd
     */
    private String completedAt;

    /**
     * 皮具样品对象
     */
    private String sampleId;

    /**
     * 皮具破损描述
     */
    private String issue;

    /**
     * 破损处的照片
     */
    private String[] images;

    /**
     * 维修费用，格式：10.00元
     */
    private String fee;

    /**
     * 评分
     */
    private int grade;

    /**
     * 评价
     */
    private String appraise;

    /**
     * 备注
     */
    private String remarks;
}
