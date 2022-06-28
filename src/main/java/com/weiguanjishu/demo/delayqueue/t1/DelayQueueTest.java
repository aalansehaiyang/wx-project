package com.weiguanjishu.demo.delayqueue.t1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * DelayQueue 方式来实现延迟任务
 */
public class DelayQueueTest {

    public static void main(String[] args) {
        DelayQueue<DelayTask> dq = new DelayQueue<DelayTask>();
        //生产者生产一个2秒的延时任务
        new Thread(new ProducerDelay(dq, 2000)).start();
        //开启消费者轮询
        new Thread(new ConsumerDelay(dq)).start();
    }

}

class ProducerDelay implements Runnable {
    DelayQueue<DelayTask> delayQueue;
    int delaySecond;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ProducerDelay(DelayQueue<DelayTask> delayQueue, int delaySecond) {
        this.delayQueue = delayQueue;
        this.delaySecond = delaySecond;
    }

    @Override
    public void run() {

        for (int i = 1; i < 6; i++) {
            delayQueue.add(new DelayTask(delaySecond, i + ""));
            System.out.println(sdf.format(new Date()) + " Thread " + Thread.currentThread() + " 添加了一个延迟任务，id=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerDelay implements Runnable {
    DelayQueue<DelayTask> delayQueue;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ConsumerDelay(DelayQueue<DelayTask> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        while (true) {
            DelayTask delayTask = null;
            try {
                delayTask = delayQueue.take();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //如果Delay元素存在,则任务到达超时时间
            if (delayTask != null) {
                //处理任务
                System.out.println(sdf.format(new Date()) + " Thread " + Thread.currentThread() + " 消费了一个延迟任务，id=" + delayTask.getId());
            } else {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

@Data
@AllArgsConstructor
class DelayTask implements Delayed {
    String id;

    // 延迟截止时间（单面：毫秒）
    long delayTime = System.currentTimeMillis();

    public DelayTask(long delayTime, String id) {
        this.delayTime = (this.delayTime + delayTime);
        this.id = id;
    }

    @Override
    // 获取剩余时间
    public long getDelay(TimeUnit unit) {
        return unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    // 队列里元素的排序依据
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return DateFormat.getDateTimeInstance().format(new Date(delayTime));
    }

}