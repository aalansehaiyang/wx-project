package com.weiguanjishu.demo.thread1;

import lombok.SneakyThrows;

/**
 * @Author Tom哥
 */
public class ThreadT1 {

    private static Long value = 1L;

    @SneakyThrows
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            System.out.println(value);
        });

        value = 2L;
        threadA.start();

        // 防止线程过早退出
        Thread.sleep(5_000);
    }
}
