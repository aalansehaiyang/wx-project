package com.weiguanjishu.event;
import org.springframework.context.ApplicationEvent;

public abstract class AbstractGenericEvent<T> extends ApplicationEvent {

    public AbstractGenericEvent(T source) {
        super(source);
    }

    @Override
    public T getSource() {
        return (T) super.getSource();
    }

}