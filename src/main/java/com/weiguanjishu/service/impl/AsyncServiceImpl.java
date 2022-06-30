package com.weiguanjishu.service.impl;

import com.weiguanjishu.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Async("defaultThreadPoolExecutor")
    public Boolean execute(Integer num) {
        System.out.println("线程：" + Thread.currentThread().getName() + " , 任务：" + num);
        return true;
    }

}
