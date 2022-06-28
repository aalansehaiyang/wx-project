package com.weiguanjishu.demo.function;

import java.util.List;
import java.util.function.Predicate;

/**
 * @Author onlyone
 * 面向函数编程
 */
public class FuncitionProgram {

    private List<Activity> activityList;

    /**
     * 基础查询骨架
     */
    Activity queryByPredicate(Predicate<Activity> predicate) {
        for (Activity activity : activityList) {
            if (predicate.test(activity)) {
                return activity;
            }
        }
        return null;
    }

    // 按id查询活动
    public Activity queryById(String id) {
        return queryByPredicate(activity -> id.equals(activity.getId()));
    }

    // 按名称查询活动
    public Activity queryByName(String name) {
        return queryByPredicate(activity -> name.equals(activity.getName()));
    }

    // id判断函数
    public Predicate<Activity> idPredicate(String id) {
        return activity -> id.equals(activity.getId());
    }

    // 名称判断函数
    public Predicate<Activity> namePredicate(String name) {
        return activity -> name.equals(activity.getName());
    }

    public void test() {
        String id = null;
        String name = null;

        // 按id查询活动
        queryByPredicate(idPredicate(id));
        // 按名称查询活动
        queryByPredicate(namePredicate(name));
        // 按id、名称组合条件查询活动
        queryByPredicate(idPredicate(id).and(namePredicate(name)));
    }

}
