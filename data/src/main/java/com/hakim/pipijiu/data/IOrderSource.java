package com.hakim.pipijiu.data;

import com.hakim.pipijiu.data.entities.Order;

import rx.Observable;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/7 19:05 <br/>
 * Desc  :
 */
public interface IOrderSource extends IDataSource<Order> {

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    Observable<Boolean> cancelOrder(String orderId);

    /**
     * 还原订单
     *
     * @param orderId
     * @return
     */
    Observable<Boolean> undoOrder(String orderId);

    /**
     * 完成订单
     *
     * @param orderId
     * @return
     */
    Observable<Boolean> completeOrder(String orderId);
}
