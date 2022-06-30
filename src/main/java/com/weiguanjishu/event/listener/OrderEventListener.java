package com.weiguanjishu.event.listener;


import com.alibaba.fastjson.JSON;
import com.weiguanjishu.domain.model.OrderModel;
import com.weiguanjishu.event.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * 事件监听器
 */
@Slf4j
@Component
public class OrderEventListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent event) {

        System.out.println("[消费端]" + "线程：" + Thread.currentThread().getName() + "，消费事件 " + JSON.toJSONString(event.getSource()));


    }
}
