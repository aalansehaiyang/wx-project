package com.weiguanjishu.demo.function;

import java.util.List;

/**
 * @Author onlyone
 * 面向对象编程
 */
public class OOP {


    public Activity queryById(List<Activity> activityList, String id) {
        for (Activity activity : activityList) {
            if (id.equals(activity.getId())) {
                return activity;
            }
        }
        return null;
    }

    public Activity queryByName(List<Activity> activityList, String name) {
        for (Activity activity : activityList) {
            if (name.equals(activity.getId())) {
                return activity;
            }
        }
        return null;
    }
}


