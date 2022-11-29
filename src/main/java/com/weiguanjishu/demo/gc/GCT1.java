package com.weiguanjishu.demo.gc;

import lombok.SneakyThrows;

/**
 * @Author Tom哥
 */
public class GCT1 {

    public GCT1() {
        System.out.println("对象初始化.....");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("对象被回收");
    }


    @SneakyThrows
    public static void main(String[] args) {
        new GCT1();

        // 触发垃圾回收
        System.gc();

        Thread.sleep(10_000);
    }

}
