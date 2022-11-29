package com.weiguanjishu.demo.volatile1;

/**
 * @Author Tom哥
 */
public class VolatileT1 {
    volatile int i;

    public void addI() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileT1 volatileT1 = new VolatileT1();
        for (int n = 1; n <= 1000; n++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    volatileT1.addI();
                }
            }).start();
        }
        Thread.sleep(10000);//等待10秒，保证上面程序执行完成
        System.out.println(volatileT1.i);
    }
}