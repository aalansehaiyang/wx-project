package com.weiguanjishu.demo.async;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTest2 {

    public static void main(String[] args) {
        CompletableFuture<Integer> resultFuture = CompletableFuture.supplyAsync(() -> {
            //模拟耗时2秒处理订单
            timeConsuming(2000);
            //返回订单金额
            return 60;
        }).thenCompose(value ->
                CompletableFuture.supplyAsync(() -> {
                    //根据订单金额计算积分
                    if (value < 50) {
                        return 1;
                    } else {
                        return 2;
                    }
                })
        );

        try {
            Integer result = resultFuture.get(5, TimeUnit.SECONDS);
            System.out.println("积分 = " + result);//result=1
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
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
