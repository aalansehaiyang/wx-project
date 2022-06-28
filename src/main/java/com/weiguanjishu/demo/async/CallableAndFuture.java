package com.weiguanjishu.demo.async;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author Tom哥
 */
public class CallableAndFuture {

    public static ExecutorService executorService = new ThreadPoolExecutor(4, 40,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build(), new ThreadPoolExecutor.AbortPolicy());


    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "异步处理，Callable 返回结果";
        }
    }

    public static void main(String[] args) {
        Future<String> future = executorService.submit(new MyCallable());
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            // nodo
        } finally {
            executorService.shutdown();
        }
    }
}
