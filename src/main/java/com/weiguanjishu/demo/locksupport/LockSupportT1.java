package com.weiguanjishu.demo.locksupport;

import lombok.SneakyThrows;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author Tom哥
 */
public class LockSupportT1 {


    @SneakyThrows
    private static void m1() {
        Thread threadA = new Thread(() -> {
            System.out.println("阻塞了");
            LockSupport.park();
            System.out.println("线程 A 拿到通行证，继续执行......");

        });


        threadA.start();
        Thread.sleep(5000L);

        //给 线程A 颁发了 “通行证”
        LockSupport.unpark(threadA);

        // 防止主线程过早退出
        Thread.sleep(10_000);

    }


    public static void main(String[] args) throws InterruptedException {
        m1();
    }


}
