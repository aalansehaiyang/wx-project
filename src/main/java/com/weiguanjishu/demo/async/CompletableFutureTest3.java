package com.weiguanjishu.demo.async;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;


/**
 * Java异步编程之Future、CompletableFuture
 * https://developer.aliyun.com/article/783151
 */
public class CompletableFutureTest3 {

    @SneakyThrows
    public static void main(String[] args) {
        CompletableFuture<Integer> resultFuture = CompletableFuture.supplyAsync(() -> {
            //模拟耗时1秒获取A书店价格
            timeConsuming(4000);
            //返回价格
            return 30;
        }).thenCombine(
                CompletableFuture.supplyAsync(() -> {
                    //模拟耗时1秒获取B书店价格
                    timeConsuming(4000);
                    //返回价格
                    return 50;
                }), (a, b) -> {
                    System.out.println("a=" + a);//30
                    System.out.println("b=" + b);//50
                    return (a + b) / 2;
                }
        );

        System.out.println("平均价 = " + resultFuture.get());
    }

    /**
     * 模拟耗时处理
     *
     * @param millis
     */
    public static void timeConsuming(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
