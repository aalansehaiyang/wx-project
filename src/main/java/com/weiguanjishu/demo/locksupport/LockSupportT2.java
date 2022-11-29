package com.weiguanjishu.demo.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author Tom哥
 */
public class LockSupportT2 {

    static class ThreadA extends Thread {
        private Object object;

        public ThreadA(Object object) {
            this.object = object;
        }

        public void run() {
            System.out.println("ThreadA 开始运行....");
            try {
                // 休眠5s
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = (Thread) object;
            // 中断线程
            thread.interrupt();
            System.out.println("ThreadA 对主线程 interrupt");
        }
    }

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA(Thread.currentThread());
        threadA.start();
        System.out.println("主线程：before park");

        // 主线程被阻塞
        LockSupport.park();

        System.out.println("主线程：after park");
    }
}
