package com.weiguanjishu.demo.function;

import lombok.Data;

import java.util.Date;

/**
 * @Author onlyone
 * <p>
 * 活动模型
 */
@Data
public class Activity {

    private Long id; // 活动id
    private String name; // 名称
    private String desc;  // 描述
    private Date time;  // 活动时间
    private String publisher; // 发布人
}
