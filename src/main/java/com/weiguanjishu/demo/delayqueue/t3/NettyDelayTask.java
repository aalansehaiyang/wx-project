package com.weiguanjishu.demo.delayqueue.t3;


import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

public class NettyDelayTask {
    private static Long startTime = System.currentTimeMillis();

    public static Long costTime() {
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    public static void main(String[] args) {
        // 初始化netty时间轮
        HashedWheelTimer timer = new HashedWheelTimer(1, // 时间间隔
                TimeUnit.SECONDS,
                10); // 时间轮中的槽数

        TimerTask task1 = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("已经过了" + costTime() + " 秒，task1 开始执行");
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("已经过了" + costTime() + " 秒，task2 开始执行");
            }
        };

        TimerTask task3 = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("已经过了" + costTime() + " 秒，task3 开始执行");
            }
        };

        // 将任务添加到延迟队列
        timer.newTimeout(task1, 0, TimeUnit.SECONDS);
        timer.newTimeout(task2, 3, TimeUnit.SECONDS);
        timer.newTimeout(task3, 21, TimeUnit.SECONDS);

    }
}
