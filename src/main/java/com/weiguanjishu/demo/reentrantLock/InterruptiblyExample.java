package com.weiguanjishu.demo.reentrantLock;

import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Tom哥
 */
public class InterruptiblyExample {

    @SneakyThrows
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        // 线程 1
        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("线程 1：获取到锁.....");
            // 线程 1 未释放锁

        }, "线程 1");

        // 线程 2
        Thread t2 = new Thread(() -> {
            try {
                // 先休眠 1 s，让线程 1 先执行
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("线程 2: 等待获取锁....");
            // 获取锁
            
            try {
                lock.lockInterruptibly();
                System.out.println("线程 2： 获取锁成功....");
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                lock.unlock();
            }
        }, "线程 2");

        t1.start();
        t2.start();

        Set set = new HashSet();
        set.add("adafd");
        set.add("sdafd ");


        Thread.sleep(5_000);
        // 线程 2 中断
        t2.interrupt();

        Thread.sleep(10_000);

    }

}