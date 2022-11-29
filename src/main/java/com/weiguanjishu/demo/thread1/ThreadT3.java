package com.weiguanjishu.demo.thread1;

import lombok.SneakyThrows;

/**
 * @Author Tom哥
 */
public class ThreadT3 {

    private static Long value = 1L;

    /**
     * 线程中断原则
     */
    @SneakyThrows
    public static void main(String[] args) {
        Thread threadB = new Thread(() -> {
            value = 2L;
        });

        threadB.start();
        threadB.join();


        System.out.println("value：" + value);
        // 防止线程过早退出
        Thread.sleep(5_000);
    }
}

