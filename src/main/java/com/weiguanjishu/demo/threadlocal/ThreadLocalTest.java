package com.weiguanjishu.demo.threadlocal;

/**
 * @Author onlyone
 */
public class ThreadLocalTest {

    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        threadLocal.set("Tom哥");
        System.out.println(threadLocal.get());
        // Thread 对象中持有一个ThreadLocal.ThreadLocalMap的成员变量。
        // 值会覆盖
        threadLocal.set("judy");
        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());


    }
}
