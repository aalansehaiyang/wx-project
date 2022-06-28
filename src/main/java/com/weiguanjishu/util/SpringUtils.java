package org.unitedata.scplatform.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 * spring 工具类
 */
@Component
public final class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    private SpringUtils() {
    }

    public static <T> T getBean(Class<T> clazz) {
        if (Objects.isNull(context) || Objects.isNull(clazz)) {
            return null;
        }

        return context.getBean(clazz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] getBeans(Class<T> clazz) {
        T[] arr = (T[]) Array.newInstance(clazz, 0);
        if (Objects.isNull(context) || Objects.isNull(clazz)) {
            return arr;
        }

        return context.getBeansOfType(clazz).values().toArray(arr);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        T bean = getApplicationContext().getBean(name, clazz);
        return bean;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
