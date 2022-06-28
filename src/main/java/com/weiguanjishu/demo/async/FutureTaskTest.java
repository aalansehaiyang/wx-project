package com.weiguanjishu.demo.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Author Tom哥
 */
public class FutureTaskTest {

    public static void main(String args[]) {

        ExecutorService executor = Executors.newCachedThreadPool();

        // FutureTask包装callbale任务，再交给线程池执行
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println("子线程开始计算：");
            Integer sum = 0;
            for (int i = 1; i <= 100; i++)
                sum += i;
            return sum;
        });

        // 线程池执行任务， 运行结果在futureTask对象里面
        executor.submit(futureTask);

        try {
            System.out.println("task运行结果计算的总和为：" + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

}