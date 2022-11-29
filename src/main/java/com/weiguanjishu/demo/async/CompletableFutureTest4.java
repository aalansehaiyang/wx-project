package com.weiguanjishu.demo.async;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

/**
 * @Author Tom哥
 */
public class CompletableFutureTest4 {
    public static void main(String[] args) throws InterruptedException {

        m3();

        Thread.sleep(10000L);
    }

    @SneakyThrows
    public static void m13() {

        Integer age = -1;
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("输入的数据不合法");
            }
            if (age >= 18) {
                return "成年人";
            } else {
                return "未成年人";
            }
        }).thenApply((str) -> {
            System.out.println("进入游戏");
            return str;
        }).whenComplete(
                (result, ex) -> {
                    if (ex != null) {
                        System.out.println("抛异常啦。。。  ");
                    }
                }
        );

        // 两种结果：
        //1、正常运行的结果
        //2、异常
        System.out.println(future.get());
    }

    @SneakyThrows
    public static void m12() {

        Integer age = 9;
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("输入的数据不合法");
            }
            if (age >= 18) {
                return "成年人";
            } else {
                return "未成年人";
            }
        }).thenApply((str) -> {
            System.out.println("进入游戏");
            return str;
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("抛异常啦。。。  " + ex.getMessage());
                return "Unknown!";
            } else {
                return result;
            }

        });
        System.out.println(future.get());
    }


    @SneakyThrows
    public static void m11() {

        Integer age = -8;
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("输入的数据不合法");
            }
            if (age >= 18) {
                return "成年人";
            } else {
                return "未成年人";
            }
        }).thenApply((str) -> {
            System.out.println("进入游戏");
            return str;
        }).exceptionally(ex -> {
            System.out.println("抛异常啦。。。  " + ex.getMessage());
            return "Unknown!";
        });

        System.out.println(future.get());
    }

    public static void m10() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务1 运行完成 ");
            return "任务 1 ";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务2 运行完成 ");
            return "任务 2 ok ！";
        });

        CompletableFuture<Void> future = future1.runAfterEither(future2, () -> {
            System.out.println("有一个任务已经结束");
        });

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void m9() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务1 运行完成 ");
            return "任务 1 ";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务2 运行完成 ");
            return "任务 2 ok ！";
        });

        CompletableFuture<Void> future = future1.acceptEither(future2, (result) -> {
            System.out.println("最后结果：" + result);
        });

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void m8() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务1 运行完成 ");
            return "任务 1 ";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务2 运行完成 ");
            return "任务 2 ok ！";
        });

        CompletableFuture<String> future = future1.applyToEither(future2, (result) -> {
            System.out.println("最后结果：" + result);
            return "任务 3";
        });

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @SneakyThrows
    public static void m7() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1 运行完成 ");
            return "任务 1 ok ！";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2 运行完成 ");
            return "任务 2 ok ！";
        });

        CompletableFuture<Void> future = future1.runAfterBoth(future2, () -> {
            System.out.println("任务结束");
        });

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static void m6() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hello ");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Tom哥");

        CompletableFuture<Void> future = future1.thenAcceptBoth(future2, (s1, s2) -> {
            System.out.println("结果：" + s1 + s2);
        });

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @SneakyThrows
    public static void m5() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hello ");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Tom哥");

        CompletableFuture<String> future = future1.thenCombine(future2, (s1, s2) -> s1 + s2);

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static void m4() {
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> "100")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "110"))
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> Double.parseDouble(s)));

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SneakyThrows
    public static void m3() {

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " 开始执行「任务 1」.....");
            return 10;
        });

        CompletableFuture<Void> cf2 = cf1.thenRunAsync(() -> {
            System.out.println(Thread.currentThread() + " 开始执行「任务 2」.....");
        });

        //等待任务2执行完成
        System.out.println("任务 cf2 的计算结果->" + cf2.get());
    }

    @SneakyThrows
    public static void m2() {

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " 开始执行「任务 1」.....");
            return 10;
        });

        CompletableFuture<Void> cf2 = cf1.thenAcceptAsync((result) -> {
            System.out.println(Thread.currentThread() + " 开始执行「任务 2」.....");
            result += 20;
            System.out.println("result = " + result);
        });

        //等待任务2执行完成
        System.out.println("任务 cf2 的计算结果->" + cf2.get());
    }

    @SneakyThrows
    public static void m1() {

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " 开始执行「任务 1」.....");
            return 10;
        });

        CompletableFuture<Integer> cf2 = cf1.thenApplyAsync((result) -> {
            System.out.println(Thread.currentThread() + " 开始执行「任务 2」.....");
            result += 20;
            return result;
        });

        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }


}
