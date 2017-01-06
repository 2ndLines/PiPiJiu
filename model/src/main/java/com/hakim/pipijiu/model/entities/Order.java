package com.hakim.pipijiu.model.entities;

import java.util.List;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/7 16:59 <br/>
 * Desc  : 修护订单
 */
public class Order {
    private String id;
    /**
     * 订单编号
     */
    private String number;
    /**
     * 顾客Id
     */
    private String guestId;
    /**
     * 商家Id
     */
    private String mchtId;

    /**
     * 运送方式
     */
    private Convey convey;

    /**
     * 订单中需维修的皮具列表
     */
    private List<Repair> repairs;

    /**
     * 总金额
     */
    private String amount;

    /**
     * 修护状态：0，待处理;1：处理中;2：完成;3：运送中;4：结束;5:取消
     */
    private String status;

}
