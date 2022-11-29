package com.weiguanjishu.demo.thread1;

import lombok.SneakyThrows;

/**
 * @Author Tom哥
 */
public class ThreadT2 {


    private static Long value = 1L;

    /**
     * 线程中断原则
     */
    @SneakyThrows
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(value);
            }
        });

        threadA.start();
        value = 2L;

        // 线程中断
        threadA.interrupt();

        // 防止线程过早退出
        Thread.sleep(5_000);
    }
}
