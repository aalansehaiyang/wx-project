package com.weiguanjishu.controller;

import com.weiguanjishu.domain.model.OrderModel;
import com.weiguanjishu.event.OrderEvent;
import com.weiguanjishu.service.AsyncService;
import com.weiguanjishu.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author onlyone
 * @create 2022/6/28
 */
@RestController
@RequestMapping("/wx/tomge/order/")
public class OrderController {

    /**
     * 访问地址：http://127.0.0.1:8090/wx/tomge/order/create_order?count=3
     */
    @RequestMapping("/create_order")
    public Object run(@RequestParam(value = "count") Integer count) {

        for (int i = 1; i <= count; i++) {
            OrderModel orderModel = new OrderModel();
            orderModel.setOrderId((long) i);
            orderModel.setBuyerName("Tom-" + i);
            orderModel.setSellerName("judy-" + i);
            orderModel.setAmount(100L);
            // 发布Spring事件通知
            SpringUtils.getApplicationContext().publishEvent(new OrderEvent(orderModel));
            System.out.println("[生产端]" + "线程：" + Thread.currentThread().getName() + "，发布事件 " + i);
        }
        return "success";

    }
}
