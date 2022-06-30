package com.weiguanjishu.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单
 */
@Data
public class OrderModel {

    private Long orderId;

    private String buyerName;

    private String sellerName;

    private double amount;
}
