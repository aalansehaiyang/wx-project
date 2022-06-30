package com.weiguanjishu.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
public class SpringConfiguration {

    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster(@Qualifier("defaultThreadPoolExecutor") ThreadPoolExecutor defaultThreadPoolExecutor) {
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
        simpleApplicationEventMulticaster.setTaskExecutor(defaultThreadPoolExecutor);
        return simpleApplicationEventMulticaster;
    }

}
