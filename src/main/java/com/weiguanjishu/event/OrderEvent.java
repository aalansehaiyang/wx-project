package com.weiguanjishu.event;


import com.weiguanjishu.domain.model.OrderModel;

/**
 * spring 事件
 */
public class OrderEvent extends AbstractGenericEvent<OrderModel> {
    public OrderEvent(OrderModel source) {
        super(source);
    }
}
